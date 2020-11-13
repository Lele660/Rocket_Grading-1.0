/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newClass;

import admin.JdbcDao;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static pages.homePage.HomeController.CLASS_ID;

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
    Button students;
    @FXML
    TextField courseCode;
    @FXML
    TextField courseName;
    @FXML
    ComboBox comboStudents;
    @FXML
    Label labelStudents;
    
    Stage dialogStage = new Stage();
    Scene scene;
    ObservableList<String> comboItems = FXCollections.observableArrayList();
    public ArrayList<Integer> studentIds = new ArrayList<>();
    public static String labelStr ="";

    

    public void signOut(ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/login/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }

    public void home(ActionEvent event) throws SQLException, IOException {
        Parent hRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene hScene = new Scene(hRoot);
        Stage tertiaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tertiaryStage.setTitle("Home");
        tertiaryStage.setScene(hScene);
        tertiaryStage.show();
    }
/*
    public void done(ActionEvent event) throws SQLException, IOException { 
        validateClass();
        System.out.println(validateClass());
//        Parent dRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
//        Scene dScene = new Scene(dRoot);
//        Stage fourthStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        fourthStage.setTitle("Home");
//        fourthStage.setScene(dScene);
//        fourthStage.show();
        //pages.files.info.addClass(courseCode.getText());
    }
    */

    public void addStudents(ActionEvent event) throws SQLException, IOException {
        /*
        Parent aRoot = FXMLLoader.load(getClass().getResource("/pages/newStudents/addStudents.fxml"));
        Scene aScene = new Scene(aRoot);
        Stage fifthStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fifthStage.setTitle("Add Students");
        fifthStage.setScene(aScene);
        fifthStage.show();
        */
        //System.out.println("water");
        for(int i =0; i<studentIds.size(); i++){
            insertStudent(studentIds.get(i));
            //System.out.println(studentIds.get(i));
        }
        
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/homeCLass/homeClassPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Home Class");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            displayStudents();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        comboStudents.setItems(comboItems);
        labelStudents.setText(labelStr);
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
    /*
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
        courseName.getText());
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
*/

    private static void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
         
    }
    
    public int displayStudents(){
        int rowCount = 0;
        try {
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "select * from Rocket_Grading.Student_info";
            PreparedStatement statement = database.prepareStatement(sql);
            //System.out.println(loggerId);
            ResultSet rs = statement.executeQuery();

            //find row number in the table 
            int count = 0;
            while (rs.next()) {
                String comboItem = rs.getString("First_name") + " " + rs.getString("Last_name");
                comboItems.add(comboItem);
                count++;
            }    
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        return rowCount;
    }
    
    public void selectStudent(ActionEvent event) throws SQLException{
        // when a name is selected from the list, add it to the label down below and save its student id to a list
        String s = (String) comboStudents.getValue();
        String sFirst = s.substring(0, s.indexOf(" "));
        String sLast = s.substring(s.indexOf(" ")+1);
        //System.out.println(sFirst);
        //System.out.println(sLast);
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "select * from Rocket_Grading.Student_info where First_name = ? and Last_name = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            
            statement.setString(1,sFirst);
            statement.setString(2,sLast);
            
          
            ResultSet rs = statement.executeQuery();
            
            if(!rs.next()){
                System.out.println("something is wrong");
            }
            else{
                int studentId;
                studentId = rs.getInt("Student_id");
                studentIds.add(studentId);
                //System.out.println(studentId);
                labelStr += s + ", ";
               // System.out.println(labelStr);
                labelStudents.setText(labelStr);
            }       
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }   
    
    }
    
    private void insertStudent(int studentId){
        try{
            JdbcDao jdbc2 = new JdbcDao();
            Connection conn = jdbc2.getConnection();

            String query = "INSERT INTO Enrollment(Student_id, Class_id) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setInt(2,getCurrentClassId());

            ps.executeUpdate();
            showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
             "slected students have been added to your class list.");
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    
    public int getCurrentClassId(){
        int id=0;
        try{
            JdbcDao jdbc2 = new JdbcDao();
            Connection conn = jdbc2.getConnection();

            String query = "SELECT * FROM Rocket_Grading.Class WHERE Class_Name = ? AND Class_code = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, courseName.getText());
            ps.setString(2, courseCode.getText());
            //System.out.println(courseName.getText());
            //System.out.println(courseCode.getText());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("Class_Id");
                CLASS_ID = id;
                
            }else{
                System.out.println("wrong");
            }
            
        }catch(Exception e){
            e.getCause();
            e.printStackTrace();;
        }
        return id;
    }
}