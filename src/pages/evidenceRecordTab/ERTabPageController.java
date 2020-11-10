/*
 * Controlls eRTabPage.fxml
 * when buttons are pressed different things happen
 */
package pages.evidenceRecordTab;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vanessa
 */

public class ERTabPageController implements Initializable {
    @FXML
    Button signout;
    @FXML
    Button home;
    @FXML
    Button assignments;
    @FXML
    Button classList;
    @FXML
    ComboBox<String> students;
    
    ObservableList<String> comboItems = FXCollections.observableArrayList();//holds names of students that can be selected
    String classCode=pages.homePage.HomeController.classCode;//holds name of currently selected class
    
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
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/classList/classListPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Class List");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
    //brings user to the assignments screen
    public void assignments (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/Assignments/assignmentPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Assignments");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
    //adds students to comboBox
    public void Students() throws IOException {
        int spot=0;
            while(spot<=pages.files.info.S.length()){
                String comboItem =pages.files.info.getEnrolledStudnet(spot, classCode);
                if(comboItem == null){
                    spot++;
                }else{
                    comboItems.add(comboItem);
                    spot++;
                    students.setItems(comboItems);
                }
            }
    }
    /**
     * Initializes the controller class.
     */
    //doesnt work yet
    public void selectStudent(){
        try{
            pages.evidenceRecord.evidenceRecord.start();
        }catch(Exception e){
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Students();
        }catch(IOException e){
            
        }
    }
    
}
