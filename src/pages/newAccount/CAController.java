/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newAccount;

import admin.Jdbc;
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
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author vanessa
 */

    
public class CAController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button create;
    @FXML
    TextField email;
    @FXML
    PasswordField confirmPassword;
    
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    public void register(ActionEvent event) throws SQLException, IOException {
        if (username.getText().isEmpty()) {
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
                    "Please enter your email address");
        }
        if(confirmPassword.getText().isEmpty()){
            System.out.println("email");
            showAlert(Alert.AlertType.ERROR, dialogStage, "Form Error!",
                    "Please confirm your password");
        }
            System.out.println(username.getText());
            System.out.println(password.getText());

            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();

            String name = username.getText();
            String pass = password.getText();
            String emailId = email.getText();
            System.out.print(name);

            if(password.getText().equals(confirmPassword.getText())){
                pages.files.info.addUsername(username.getText());
                pages.files.info.addPassword(password.getText());
//                Jdbc jdbc = new Jdbc();
//                jdbc.insertRecord(name,emailId,pass);

                showAlert(Alert.AlertType.CONFIRMATION, dialogStage, "Registration Successful!",
                "Welcome " + username.getText());

                Parent hRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
                Scene hScene = new Scene(hRoot);
                Stage tertiaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                tertiaryStage.setTitle("Home");
                tertiaryStage.setScene(hScene);
                tertiaryStage.show();
            }else{
                showAlert(Alert.AlertType.CONFIRMATION, dialogStage, "Registration Unsuccessful!",
                "Passwords don't match");
            }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
