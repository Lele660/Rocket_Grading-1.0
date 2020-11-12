package pages.newAssignment;


import admin.Assignment;
import admin.Assignment_Grade;
import admin.JdbcDao;
import admin.Student;
import static classList.ClassListPageController2.ASSIGNMENT_MARK_ID;
import static classList.ClassListPageController2.STUDENT_LIST;
import static classList.ClassListPageController2.retrieveEnrollment;
import static classList.ClassListPageController2.retrieveStudents;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static pages.homePage.HomeController.CLASS_ID;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lelezhao
 */
public class AssignmentController implements Initializable {
    
    @FXML 
    Button btnCancel;
    @FXML
    Button btnDone;
    @FXML
    Button btnHome;
    @FXML
    Button btnAdd;
    
    @FXML
    TextField tfDescription;
    @FXML
    TextField tfName;
    @FXML
    TextField tfType;
    @FXML
    TextField tfWeight;
    @FXML
    TextField tfEname;
    @FXML
    TextField tfEdes;
    
    
    @FXML
    TableView<Assignment_Expectation> tvTable;
    @FXML
    TableColumn col_name;
    @FXML
    TableColumn col_des;
    @FXML
    ComboBox comboType;
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    // list to store instances of class 
   ObservableList<Assignment_Expectation> data = FXCollections.observableArrayList();
   ObservableList<String> types = FXCollections.observableArrayList(); 
   public static int TEMP_ID;
    
    public void done (ActionEvent event) throws SQLException{

        if(tfName.getText()==null || tfDescription.getText()==null || tfWeight.getText()==null){
            showAlert(Alert.AlertType.ERROR, "ERROR",
            "Please fill out all assignment requiremnets");
        }
 
        try{
            JdbcDao jdbc2 = new JdbcDao();
            Connection conn = jdbc2.getConnection();

            String query = "INSERT INTO Assignment (Assignment_Name,Assignment_Type,Assignment_Description,Assignment_Weight,Class_Id) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,tfName.getText());
            ps.setString(2,comboType.getSelectionModel().getSelectedItem().toString());
            //System.out.println(comboType.getSelectionModel().getSelectedItem().toString());
            ps.setString(3,tfDescription.getText() );
            ps.setInt(4,Integer.parseInt(tfWeight.getText()));
            ps.setInt(5, CLASS_ID);
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                TEMP_ID =rs.getInt(1);
            }
            rs.close();
            showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
             "This Assignment has been added to your class list.");
            createGradeId(TEMP_ID);

            // insert expectations in this class
            for(Assignment_Expectation a: data){
                for(int n:ASSIGNMENT_MARK_ID){
                    insert(a,n);
                }
              
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        
    }
    
    private static void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
         
    }
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        types.add("Presentation");
        types.add("Assignment");
        types.add("Test");
        
        comboType.setItems(types);
        
    }    
    
    
   
    
    public void add(ActionEvent event)throws Exception{
        System.out.println(tfEdes.getText());
//        if(tfEdes.getText().equals("")){
//            showAlert(Alert.AlertType.WARNING, "Warning",
//             "Are you sure this assignment has no expectation description?");
//        }
       //data.add(new Assignment_Expectation("test","test"));
       col_name.setCellValueFactory(
                new PropertyValueFactory<Assignment_Expectation, String>("name"));
       col_des.setCellValueFactory(
                new PropertyValueFactory<Assignment_Expectation, String>("des"));
      
       data.add(new Assignment_Expectation(tfEname.getText(), tfEdes.getText()));
       tvTable.setItems(data);
       tfEname.clear();
       tfEdes.clear();
    }

    
    
    public void insert(Assignment_Expectation item, int id ){
        JdbcDao jdbc2 = new JdbcDao();
        Connection conn = jdbc2.getConnection();
        
        String query = "INSERT INTO Assignment_Expectation(Expectation_name, Expectation_description, Assignment_id, Assignment_grade_id) VALUES(?,?,?,?)";
        
        try{
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,item.getName());
            statement.setString(2,item.getDes());
            statement.setInt(3,TEMP_ID);
            statement.setInt(4,id);
            
            statement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }   
    }
    
    // add an assignment grade marking entry for each student in the class
    //pass in the assiignment id that has just been created
    public void createGradeId(int assignment_id) throws SQLException{
        retrieveStudents();
        retrieveEnrollment();
        for (int i = 0; i<STUDENT_LIST.size();i++){
            createGradeId(STUDENT_LIST.get(i),assignment_id);
        }
    }
    /**
     * 
     * @param s student 
     * @param a assignment id
     */
    public void createGradeId(Student s, int a){
        JdbcDao jdbc2 = new JdbcDao();
        Connection conn = jdbc2.getConnection();
        try{
            String qr = "INSERT INTO Assignment_grade(Assignment_id, Student_id) VALUES(?,?)";
            PreparedStatement stmt = conn.prepareStatement(qr, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,a);
            stmt.setInt(2,s.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                //System.out.println("you created one");
                int grade_id = rs.getInt(1);
                ASSIGNMENT_MARK_ID.add(grade_id);
                //System.out.println("Grade id is " + grade_id);
            } else {
                System.out.println("no rows selected");
            }
            
        }catch(Exception e ){
            e.getCause();
            e.printStackTrace();
        }
    }

   
}
