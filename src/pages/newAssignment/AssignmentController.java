package pages.newAssignment;

import admin.JdbcDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static pages.homePage.HomeController.CLASS_ID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lelezhao
 */
public class AssignmentController {
    
    @FXML 
    Button btnCancel;
    @FXML
    Button btnDone;
    @FXML
    Button btnHome;
    
    @FXML
    TextArea tfDescription;
    @FXML
    TextField tfName;
    @FXML
    TextField tfType;
    @FXML
    TextField tfWeight;
    Stage dialogStage = new Stage();
    Scene scene;
    
    public void done (ActionEvent event) throws SQLException{
        try{
            JdbcDao jdbc2 = new JdbcDao();
            Connection conn = jdbc2.getConnection();

            String query = "INSERT INTO Assignment (Assignment_Name,Assignment_Type,Assignment_Description,Assignment_Weight,Class_Id) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,tfName.getText());
            ps.setString(2,tfType.getText());
            ps.setString(3,tfDescription.getText() );
            ps.setInt(4,Integer.parseInt(tfWeight.getText()));
            ps.setInt(5, CLASS_ID);
            

            ps.executeUpdate();
            showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
             "This Assignment has been added to your class list.");
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        
    }
    
    private static void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
         
    }
    
    
    
    
    
    
}
