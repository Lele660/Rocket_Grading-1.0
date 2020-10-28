/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newClass;

import admin.JdbcDao;
import admin.User;
import LoginPage.LoginController;
import static LoginPage.LoginController.loggerId;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vanes
 */
public class CreateClassController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button signOut;
    @FXML
    Button Home;
    @FXML
    Button ButtonDone;
    @FXML
    Button btnAddClass;
    @FXML
    Button addStudents;
    @FXML
    TextField courseCode;
    @FXML
    TextField courseName;
    
    Stage dialogStage = new Stage();
    Scene scene;
    public static ArrayList<Integer> loggerClasses = new ArrayList<Integer>();
    

    public void signOut(ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/login/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }

    public void home(ActionEvent event) throws SQLException, IOException {
        Parent hRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene hScene = new Scene(hRoot);
        Stage tertiaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tertiaryStage.setTitle("Home");
        tertiaryStage.setScene(hScene);
        tertiaryStage.show();
    }

    public void done(ActionEvent event) throws SQLException, IOException { 
        validateClass();
        System.out.println(validateClass());
        Parent dRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene dScene = new Scene(dRoot);
        Stage fourthStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fourthStage.setTitle("Home");
        fourthStage.setScene(dScene);
        fourthStage.show();
        //pages.files.info.addClass(courseCode.getText());
    }

    public void addStudents(ActionEvent event) throws SQLException, IOException {
        Parent aRoot = FXMLLoader.load(getClass().getResource("/pages/newStudents/addStudents.fxml"));
        Scene aScene = new Scene(aRoot);
        Stage fifthStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fifthStage.setTitle("Add Students");
        fifthStage.setScene(aScene);
        fifthStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addClass(ActionEvent event) throws SQLException{
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
       

        if (courseName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter your course name");
            return;
        }
        if(courseCode.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,  "Form Error!",
                    "Please enter your course code");
            return;
        }

        try {
            JdbcDao jdbc2 = new JdbcDao();
            Connection conn = jdbc2.getConnection();

            //first stmt, select user_Id
            String query = "INSERT INTO Class(User_Id,Class_Name,Class_Code) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            //int expectedId = loggerId;

            ps.setInt(1, loggerId);
            ps.setString(2, courseName.getText());
            ps.setString(3, courseCode.getText());
           
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
         showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
            courseName.getText() + " (" + courseCode.getText() + ")" + "has been added to your class list.");
        
    }
    
    public boolean validateClass(){
        JdbcDao jdbc = new JdbcDao();
        Connection database = jdbc.getConnection();
        String sql ="select * from Rocket_Grading.Class where Class_Name = ? and Class_code = ?";
        int loggerClassId;
 
        try{
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setString(1,courseName.getText());
            statement.setString(2,courseCode.getText());

            ResultSet queryResult = statement.executeQuery();
            if(!queryResult.next()){
                showAlert(Alert.AlertType.ERROR,"Something went wrong",
                            "course was not added successfully");

            }else{
                 showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
        "Hello " + courseName.getText());
                 //loggerCourseName = queryResult.getString("username");
                 loggerClassId = queryResult.getInt("Class_Id");
                 if(loggerClasses.add(loggerClassId)==true){
                     return true;
                 }
            }
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
            
        };
        return false;
    }

    private static void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
         
    }
    
    
    
    
}
