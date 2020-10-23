/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.login;

import admin.Jdbc;
import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.awt.*;
import java.awt.event.*;



/**
 * FXML Controller class
 *
 * @author lelezhao
 */
public class LoginController implements Initializable {
    
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button signin;
    @FXML
    Button create;
    @FXML
    TextField email;
    @FXML
    ImageView background1;
    
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    public boolean check;
    public void register(ActionEvent event) throws SQLException, IOException {
        if (event.getSource() == create){
            Parent aRoot = FXMLLoader.load(getClass().getResource("/pages/newAccount/ca.fxml"));
            Scene aScene = new Scene(aRoot);
            Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            secondaryStage.setTitle("New Account");
            secondaryStage.setScene(aScene);
            secondaryStage.show();
        }
    }
    
    public void signin (ActionEvent event) throws SQLException, IOException {
        if(username.getText().isEmpty()) {
            System.out.println("user");
            showAlert(Alert.AlertType.ERROR, dialogStage, "Form Error!",
                    "Please enter your name");
        }
        if(password.getText().isEmpty()){
            System.out.println("pass");
            showAlert(Alert.AlertType.ERROR, dialogStage, "Form Error!",
                    "Please enter your password");
        }
         if(email.getText().isEmpty()){
            System.out.println("email");
            showAlert(Alert.AlertType.ERROR, dialogStage, "Form Error!",
                    "Please enter your correct email address");
        }
         check=pages.files.info.check(username.getText(), password.getText());
         if(check==true){
            System.out.println("entered");
            Parent hRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
            Scene hScene = new Scene(hRoot);
            Stage tertiaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            tertiaryStage.setTitle("Home");
            tertiaryStage.setScene(hScene);
            tertiaryStage.show();
         }else{
             showAlert(Alert.AlertType.ERROR, dialogStage, "Form Error!",
                    "Please enter a valid account");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File classroomFile = new File("img/classroom.jpg");
        Image classroomImage = new Image(classroomFile.toURI().toString());
        background1.setImage(classroomImage);
        
        // TODO
    }    
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
