/*
 * Controlls classListPage.fxml
 * when buttons are pressed different things happen
 */
package classList;

import static LoginPage.LoginController.loggerId;
import static LoginPage.LoginController.loggerUsername;
import static LoginPage.LoginController.showAlert;
import admin.JdbcDao;
import admin.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static pages.homePage.HomeController.CLASS_ID;
import pages.newAssignment.Assignment_Expectation;

/**
 * FXML Controller class
 *
 * @author vanessa
 */
public class ClassListPageController implements Initializable {
    @FXML
    Button signout;
    @FXML
    Button home;
    @FXML
    Button assignments;
    @FXML
    Button evidenceRecord;
    @FXML
    Button btnUnenroll;
    @FXML
    ScrollPane pane;
    @FXML
    TableView table;
    @FXML 
    TableColumn col;
    @FXML 
    TableColumn col_assign;
    @FXML 
    TableColumn col_name;
    
    
//    VBox box;
     //brings user to login screen where they can login again if they wish
    public static ObservableList<String> STUDENT_NAME = FXCollections.observableArrayList();
    public static ObservableList<Student> STUDENT_LIST = FXCollections.observableArrayList();
    public static ArrayList<Integer> STUDENT_ID = new ArrayList<>();

    public static int SELECTED_STUDENT;
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/LoginPage/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    public void home (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
     //brings user to the assignments screen
    public void assignments (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/Assignments/assignmentPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Assignments");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    //brings user to the evidence record tab screen
    public void evidenceRecord (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/evidenceRecordTab/eRTabPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Evidence Record Tab");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            display();
        } catch (SQLException ex) {
            Logger.getLogger(ClassListPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    private void retrieveEnrollment()throws SQLException{
        
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql ="select * from Rocket_Grading.Enrollment where Class_Id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            //System.out.println("class id is " + CLASS_ID);
            statement.setInt(1,0);
           

            ResultSet queryResult = statement.executeQuery();
            if(queryResult==null){
                System.out.println("wrong");
                
            }else{
                // add all the student ids in the table to a static list
                while(queryResult.next()){
                    int id = queryResult.getInt("Student_id");
                    //System.out.println("student id is " + id);
                    STUDENT_ID.add(id);
                    
                }
            }
                 
        }catch(Exception e){
                e.printStackTrace();
                e.getCause();
            
                }
        //test
//        
        //System.out.println("number of terms " + STUDENT_ID.size());
        for(int id:STUDENT_ID){
            System.out.println(id);
        }
    }
    
    public void retrieveStudents() throws SQLException{
        retrieveEnrollment();
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            
            for(int i = 0; i<STUDENT_ID.size(); i++){
                String sql ="select * from Rocket_Grading.Student_info where Student_id = ?";
                PreparedStatement statement = database.prepareStatement(sql);
                statement.setInt(1,STUDENT_ID.get(i));
                ResultSet queryResult = statement.executeQuery();
                if(queryResult==null){
                    System.out.println("wrong");
           
                }else{
                // add all the student names in the table to a static list
                    while(queryResult.next()){
                        String fName = queryResult.getString("First_name");
                        String lName = queryResult.getString(("Last_name"));
                        int id = queryResult.getInt("Student_id");
                        //String name = fName + " " + lName;
                        STUDENT_LIST.add(new Student(fName,lName,id));    
                    }
                }
            }
         
        }catch(Exception e){
                e.printStackTrace();
                e.getCause();
         }
        /*
        testing
        */
//        for(Student s:STUDENT_LIST){
//            System.out.println(s.getFirstName());
//        }
//        
    }
    private void display() throws SQLException{
        retrieveStudents();
        pane.setContent(table);
        col_name.setCellValueFactory(
                new PropertyValueFactory<Student, String>("name"));

        table.setItems(STUDENT_LIST);

    }
    
    public void unenroll(ActionEvent event) throws SQLException{
        Student chosen = (Student) table.getSelectionModel().getSelectedItem();
        int id = chosen.getId();
        try{
            
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "delete from Enrollment where Student_id = ? and Class_id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setInt(2,CLASS_ID);
            statement.executeUpdate();
            showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
             "This person has been deleted successfully");
            
            //System.out.println("deleted sucessfully");
            table.getItems().remove(chosen);
            
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    
    
    
    
    
    
    }