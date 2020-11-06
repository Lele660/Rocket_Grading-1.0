/*
 * Controlls Create_Assignment.fxml
 * when buttons are pressed different things happen
 */

package pages.newAssignments;

import admin.JdbcDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
public class Create_AssignmentController {
    
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
    String cCode=pages.homePage.HomeController.classCode;
    //brings user to the assignments screen
    public void done (ActionEvent event) throws SQLException, IOException{
        /*
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
            
            Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/Assignments/Create_Assignment.fxml"));
            Scene lScene = new Scene(lRoot);
            Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            secondaryStage.setTitle("Assignments");
            secondaryStage.setScene(lScene);
            secondaryStage.show();
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
*/
        //for vanessa's code
        String name= tfName.getText()+" "+tfType.getText();
        pages.files.info.addAssignment(name, cCode);
        
        Parent crRoot = FXMLLoader.load(getClass().getResource("/pages/assignments/assignmentPage.fxml"));
        Scene crScene = new Scene(crRoot);
        Stage fourthStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fourthStage.setTitle("Create Class");
        fourthStage.setScene(crScene);
        fourthStage.show();
        
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
    
    private static void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
         
    }
    
    
    
    
    
    
}
