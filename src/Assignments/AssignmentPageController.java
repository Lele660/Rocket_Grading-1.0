/*
 * Controlls assignmentPage.fxml
 * when buttons are pressed different things happen
 */
package Assignments;

import static LoginPage.LoginController.showAlert;
import admin.Assignment;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static pages.homePage.HomeController.CLASS_ID;
import pages.newAssignment.Assignment_Expectation;

/**
 * FXML Controller class
 *
 * @author vanessa
 */
public class AssignmentPageController implements Initializable {
    @FXML
    Button signout;
    @FXML
    Button home;
    @FXML
    Button evidenceRecord;
    @FXML
    Button classList;
    @FXML
    Button newAssignment;
    @FXML
    Button  btnMark;
    @FXML
    TableView tbp;
    @FXML
    TableView tbt;
    @FXML
    TableView tba;
    @FXML
    TableColumn presentation;
    @FXML
    TableColumn test;
    @FXML
    TableColumn assignment;
    
    //each observable list correspond with one of the tables 
    public static ObservableList<Assignment> ASSIGNMENT_LIST = FXCollections.observableArrayList();
    ObservableList<Assignment> t_presentations = FXCollections.observableArrayList();
    ObservableList<Assignment> t_tests = FXCollections.observableArrayList();
    ObservableList<Assignment> t_assignments = FXCollections.observableArrayList();
    public static Assignment SELECTED_ASSIGNMENT;
    
    
     //brings user to login screen where they can login again if they wish
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/LoginPage/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
    //brings user to the home screen
    public void home (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Home");
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
    //brings user to the evidence record tab screen
    public void evidenceRecord (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/evidenceRecordTab/eRTabPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Evidence Record Tab");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
    public void newAssignment (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/newAssignments/Create_Assignment.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("New Assignments");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        getAssignments();
        display();
        
    }    
    public static void getAssignments(){
        JdbcDao jdbc = new JdbcDao();
        Connection database = jdbc.getConnection();
        String sql ="select * from Rocket_Grading.Assignment where Class_Id = ?";
        
//        String varification = "SELECT * FROM Rocket_Grading.login WHERE username = '" + username.getText()+"', email = '"+ email.getText() +"' AND password = '" + password.getText() +"'";
//        System.out.println(varification);
        try{
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,CLASS_ID);

            ResultSet qr = statement.executeQuery();
            if(qr==null){
                showAlert(Alert.AlertType.ERROR,"",
                            "No Assignment has been created yet");

            }else{
                while(qr.next()){
                    ASSIGNMENT_LIST.add(new Assignment(qr.getString("Assignment_Name"),qr.getInt("Assignment_Id"),
                    qr.getString("Assignment_Type")));
                }
                 
            }       
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
            
        };
        
    
        //for(Assignment a:assignment_list){
          //  System.out.println(a.getName());
        //}
    }
    
    public void display(){
        sort();
        presentation.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("name"));
        test.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("name"));
        assignment.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("name"));
        tba.setItems(t_assignments);
        tbp.setItems(t_presentations);
        tbt.setItems(t_tests);
    }
    
    public void sort(){
        for(int i=0;i<ASSIGNMENT_LIST.size ();i++){
            if(ASSIGNMENT_LIST.get(i).getType().equals("Presentation")){
                t_presentations.add(ASSIGNMENT_LIST.get(i));
            }
            else if(ASSIGNMENT_LIST.get(i).getType().equals("Tests")){
                t_tests.add(ASSIGNMENT_LIST.get(i));
            }
            else{
                t_assignments.add(ASSIGNMENT_LIST.get(i));
            }
        }
            
    }
    
    public void mark (ActionEvent event)throws SQLException, IOException{
       
        if(tbp.getSelectionModel().getSelectedItem()!=null){
            SELECTED_ASSIGNMENT= (Assignment) tbp.getSelectionModel().getSelectedItem();
        }else if(tbt.getSelectionModel().getSelectedItem()!=null){
            SELECTED_ASSIGNMENT = (Assignment) tbt.getSelectionModel().getSelectedItem();
        }else if(tba.getSelectionModel().getSelectedItem()!=null){
            SELECTED_ASSIGNMENT = (Assignment) tba.getSelectionModel().getSelectedItem();
        } else{
             showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "No assignment has been selected");
        }
        //System.out.println("selected name is " + SELECTED.getName());
        
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/Grading/grading.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Grading Tab");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        
    }
    
    
}
