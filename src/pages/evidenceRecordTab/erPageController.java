/*
 * Controlls eRTabPage.fxml
 * when buttons are pressed different things happen
 */
package pages.evidenceRecordTab;

import admin.JdbcDao;
import admin.Student;
import static classList.ClassListPageController.STUDENT_LIST;
import static classList.ClassListPageController.retrieveEnrollment;
import static classList.ClassListPageController.retrieveStudents;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import pages.evidenceRecord.evidence_Record;

/**
 * FXML Controller class
 *
 * @author vanessa
 */


public class erPageController implements Initializable {


    @FXML
    Button signout;
    @FXML
    Button home;
    @FXML
    Button assignments;
    @FXML
    Button classList;
    @FXML
    ComboBox students;
    
    
    
    public static Student CHOSEN = null;
    ObservableList<Student> comboItems = FXCollections.observableArrayList();//holds names of students that can be selected
    //String classCode=pages.homePage.HomeController.classCode;//holds name of currently selected class
    
    //brings user to login screen where they can login again if they wish
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/pLogin/pLogin.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    //brings user to the home screen
    public void home (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
     //brings user to the class list screen
    public void classList (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/classList/classListPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Class List");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
    //brings user to the assignments screen
    public void assignments (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/Assignments/assignmentPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Assignments");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            displayStudents();
        } catch (SQLException ex) {
            //Logger.getLogger(erPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       students.setItems(comboItems);
    }
    
    public void displayStudents() throws SQLException{
        STUDENT_LIST.clear();
        Student comboItem = null;
        retrieveStudents();
        System.out.println("number of students on list " + STUDENT_LIST.size());
        for(Student s:STUDENT_LIST){
            comboItem = s;
            comboItems.add(comboItem);
        }
        
    }
    
    public void selectStudent(ActionEvent event) throws IOException{
        CHOSEN = (Student) students.getValue();
        System.out.println("go");
        evidence_Record er=new evidence_Record();
        try{
            er.ER();
        }catch(Exception e){

        }
        
       
    }
    
    /**
     * Initializes the controller class.
     */
    //doesnt work yet


//    public void selectStudent(){
//        try{
//            pages.evidenceRecord.evidence_Record.start();
//        }catch(Exception e){
//            
//        }
//    }
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        try{
//            Students();
//        }catch(IOException e){
//            
//        }
//    }

 
//    public void selectStudent(){
//        try{
//            pages.evidenceRecord.evidenceRecord.ER();
//        }catch(Exception e){
//            
//        }
//    }
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        try{
//            Students();
//        }catch(IOException e){
//            
//        }
//    }
    
}
