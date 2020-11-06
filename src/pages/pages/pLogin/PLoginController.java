  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.pLogin;
import admin.JdbcDao;
import admin.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 * FXML Controller class
 *
 * @author lelezhao
 */
public class PLoginController implements Initializable {
    
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button signin;
    @FXML
    Button register;
    @FXML
    TextField email;
    @FXML
    ImageView background1;
    public static String loggerUsername ="";
    
    public static int loggerId = 12;
    
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    
    //brings user to the creating an account page
    public void register(ActionEvent event) throws SQLException, IOException {
        //createUser();
//        showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
//        "Resgistration successful " + username.getText());
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/newAccount/ca.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Creating an Account");
        secondaryStage.setScene(lScene);
        secondaryStage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File classroomFile = new File("img/classroom.jpg");
        Image classroomImage = new Image(classroomFile.toURI().toString());
        background1.setImage(classroomImage);
        
        // TODO
    }    
    private static void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    
    //this doesnt work on mine
    /*
    public void validateLogin(){
        JdbcDao jdbc = new JdbcDao();
         Connection database = jdbc.getConnection();
        String sql ="select * from Rocket_Grading.User where username = ? and password = ?";
        
        String varification = "SELECT * FROM Rocket_Grading.login WHERE username = '" + username.getText()+"', email = '"+ email.getText() +"' AND password = '" + password.getText() +"'";
        System.out.println(varification);
        try{
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setString(1,username.getText());
            statement.setString(2,password.getText());

            ResultSet queryResult = statement.executeQuery();
            if(!queryResult.next()){
                showAlert(Alert.AlertType.ERROR,"Something went wrong",
                            "Please enter the correct username and password");

            }else{
                 showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
        "welcome back " + username.getText());
                 loggerUsername = queryResult.getString("username");
                 loggerId = queryResult.getInt("UserId");
                 
            }
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
            
        };
    }
*/
    //checks if user is registered and if so they get logged in
    public void signin(ActionEvent event) throws SQLException, IOException {
        boolean check= pages.files.info.check(username.getText(), password.getText());
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
       

        if (username.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter your name");
            return;
        }
        if(password.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,  "Form Error!",
                    "Please enter your password");
            return;
        }
        
        if(email.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter your correct email address");
            return;
        }
        if (username.getText().isEmpty() == false && password.getText().isEmpty() == false) {
            if(check==true){
                Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
                Scene lScene = new Scene(lRoot);
                Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                secondaryStage.setTitle("Home");
                secondaryStage.setScene(lScene);
                secondaryStage.show();
            }
//            validateLogin();
//            User sample = new User(username.getText());
        }else{
            showAlert(Alert.AlertType.ERROR,"Something went wrong", "Please enter username and password");
        }
    }
    /*
    public void createUser(){
        JdbcDao jdbc2 = new JdbcDao();
        Connection conn = jdbc2.getConnection();
        
        String query = "INSERT INTO User(username,email,password) VALUES(?,?,?)";
        
        try{
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,username.getText());
            statement.setString(2,email.getText());
            statement.setString(3,password.getText());
            
            statement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }   
    } 
*/

}