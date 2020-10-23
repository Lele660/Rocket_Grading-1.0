/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    Button done;
    @FXML
    Button addStudents;
    @FXML
    TextField courseCode;
    
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
    public void done (ActionEvent event) throws SQLException, IOException {
        Parent dRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene dScene = new Scene(dRoot);
        Stage fourthStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fourthStage.setTitle("Home");
        fourthStage.setScene(dScene);
        fourthStage.show();
        pages.files.info.addClass(courseCode.getText());
    }
    public void addStudents (ActionEvent event) throws SQLException, IOException {
        Parent aRoot = FXMLLoader.load(getClass().getResource("/pages/newStudents/addStudents.fxml"));
        Scene aScene = new Scene(aRoot);
        Stage fifthStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fifthStage.setTitle("Add Students");
        fifthStage.setScene(aScene);
        fifthStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
