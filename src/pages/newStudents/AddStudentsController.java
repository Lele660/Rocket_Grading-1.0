/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newStudents;

import static LoginPage.LoginController.loggerId;
import admin.JdbcDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static pages.homePage.HomeController.CLASS_ID;

/**
 * FXML Controller class
 *
 * @author vanes
 */
public class AddStudentsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button signOut;
    @FXML
    Button Home;
    @FXML
    Button create;
    @FXML
    Button cancel;
    @FXML
    TextField sFirstName;
    @FXML
    TextField sLastName;
    @FXML
    ComboBox comboClasses;
    ObservableList<String> comboItems = FXCollections.observableArrayList();
    Stage dialogStage = new Stage();
    Scene scene;
    private static int TEMP_CLASS_ID;
    private static int TEST_STUDENT_ID;
    
    
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/login/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    public void home (ActionEvent event) throws SQLException, IOException {
        Parent hRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene hScene = new Scene(hRoot);
        Stage tertiaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        tertiaryStage.setTitle("Home");
        tertiaryStage.setScene(hScene);
        tertiaryStage.show();
    }
    public void create (ActionEvent event) throws SQLException, IOException {
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
//        Parent crRoot = FXMLLoader.load(getClass().getResource("/pages/newClass/createClass.fxml"));
//        Scene crScene = new Scene(crRoot);
//        Stage fourthStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        fourthStage.setTitle("Create Class");
//        fourthStage.setScene(crScene);
//        fourthStage.show();
    }
    public void cancel (ActionEvent event) throws SQLException, IOException {
        Parent cRoot = FXMLLoader.load(getClass().getResource("/pages/newClass/createClass.fxml"));
        Scene cScene = new Scene(cRoot);
        Stage fifthStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fifthStage.setTitle("Create Class");
        fifthStage.setScene(cScene);
        fifthStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            displayClasses();
        } catch (SQLException ex) {
        }
        comboClasses.setItems(comboItems);
        
    }    
    
    public void addStudent(ActionEvent event){

        if (sFirstName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter the first name of the student");
            return;
        }
        if (sLastName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter the last name of the student");
            return;
        }

        try {
            JdbcDao jdbc2 = new JdbcDao();
            Connection conn = jdbc2.getConnection();

            //first stmt, select user_Id
            String query = "INSERT INTO Student_info(First_name, Last_name) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            //int expectedId = loggerId;

            ps.setString(1, sFirstName.getText());
            ps.setString(2, sLastName.getText());

            ps.executeUpdate();
            showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
                    "This student has been added successfully");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        
        
        if(!comboClasses.getSelectionModel().isEmpty()){
            try{
                // save the student id that has just been created
                int id = getStudentId();
                System.out.println(id);
                // if it's zero that means the id is not saved
                if(id!=0){
                  JdbcDao jdbc2 = new JdbcDao();
                  Connection conn = jdbc2.getConnection();

            
                  String query = "INSERT INTO Enrollment(Student_id, Class_id) VALUES(?,?)";
                  PreparedStatement ps = conn.prepareStatement(query); 
                  ps.setInt(1,id);
                  ps.setInt(2, TEMP_CLASS_ID);
                  
                  ps.executeUpdate();
                }  
            }catch(Exception e){
                e.printStackTrace();
                e.getCause();
            }
        } else {

        //showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
        //sFirstName.getText() + " " + sLastName.getText()  + "has been added to the system.");
       }
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();

    }
    
    public int getStudentId(){
        int id = 0;
        try{
            JdbcDao jdbc2 = new JdbcDao();
            Connection conn = jdbc2.getConnection();
            String query = "SELECT * FROM Rocket_Grading.Student_info WHERE First_name = ? and Last_name = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            //int expectedId = loggerId;


            ps.setString(1, sFirstName.getText());
            ps.setString(2, sLastName.getText());
           
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //System.out.println("has data");
                id = rs.getInt("Student_id");
                //System.out.println(TEST_STUDENT_ID);
            }else{
                System.out.println("wrong");
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
      return id;
    }
    
    public void displayClasses() throws SQLException {

        try {
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "select * from Rocket_Grading.Class where User_Id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1, loggerId);
            //System.out.println(loggerId);
            ResultSet rs = statement.executeQuery();

            //find row number in the table 
            int count = 0;
            while (rs.next()) {
                String comboItem = rs.getString("Class_code") + " " + rs.getString("Class_Name");
                comboItems.add(comboItem);
                count++;
            }    
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }
    
    
    
    public void selectClass(ActionEvent event){
        String s = (String) comboClasses.getValue();
        String sCode = s.substring(0, s.indexOf(" "));
        String sName = s.substring(s.indexOf(" ")+1);
        //System.out.println(sName);
        //System.out.println(sCode);
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "select * from Rocket_Grading.Class where Class_code = ? and User_Id = ? and Class_Name = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            
            statement.setString(1,sCode);
            statement.setInt(2,loggerId);
            statement.setString(3,sName);
          
            ResultSet rs = statement.executeQuery();
            
            if(!rs.next()){
                System.out.println("something is wrong");
            }
            else{
                TEMP_CLASS_ID = rs.getInt("Class_Id");
                //System.out.println(TEMP_CLASS_ID);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        
    }

   
    
}
