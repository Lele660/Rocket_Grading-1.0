//package controller;
//
//import admin.Jdbc;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import javafx.stage.Window;
//
//
//public class login implements Initializable {
//
//    @FXML
//    TextField username;
//    @FXML
//    PasswordField password;
//    @FXML
//    Button signin;
//    @FXML
//    TextField email;
//    
//    Stage dialogStage = new Stage();
//    Scene scene;
//    @FXML
//    public void register(ActionEvent event) throws SQLException, IOException {
//        
//        
//        System.out.println(username.getText());
//        System.out.println(password.getText());
//        
//        Node node = (Node)event.getSource();
//        dialogStage = (Stage) node.getScene().getWindow();
//       
//
//        if (username.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, dialogStage, "Form Error!",
//                    "Please enter your name");
//            return;
//        }
//        if(password.getText().isEmpty()){
//            showAlert(Alert.AlertType.ERROR, dialogStage, "Form Error!",
//                    "Please enter your password");
//            return;
//        }
//    
//    
//        String name = username.getText();
//        String pass = password.getText();
//        String emailId = email.getText();
//        System.out.print(name);
//
//        Jdbc jdbc = new Jdbc();
//        jdbc.insertRecord(name, emailId,pass);
//
//        showAlert(Alert.AlertType.CONFIRMATION, dialogStage, "Registration Successful!",
//        "Welcome " + username.getText());
//    }
//    
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//
//    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.initOwner(owner);
//        alert.show();
//    }
//    
//    
//}
//
