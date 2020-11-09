package pages.newAssignment;


import admin.JdbcDao;
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

            // insert expectations in this class
            for(Assignment_Expectation a: data){
                insert(a);
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
        if(tfEdes.getText().equals("")){
            showAlert(Alert.AlertType.WARNING, "Warning",
             "Are you sure this assignment has no expectation description?");
        }
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
    
       
    
   
    
    
    
    public void insert(Assignment_Expectation item){
        JdbcDao jdbc2 = new JdbcDao();
        Connection conn = jdbc2.getConnection();
        
        String query = "INSERT INTO Assignment_Expectation(Expectation_name, Expectation_description, Assignment_id) VALUES(?,?,?)";
        
        try{
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,item.getName());
            statement.setString(2,item.getDes());
            statement.setInt(3,TEMP_ID);
            
            statement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }   
    }

   
}
