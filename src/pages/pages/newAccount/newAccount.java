/*
 * opens new account page 
 * mainly used for testing
 */
package pages.newAccount;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class newAccount extends Application {
    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    //opens creating an account page
    //mainly used for testing
    public void start(Stage primaryStage) throws Exception {
        Parent NewAccountRoot = FXMLLoader.load(getClass().getResource("cA.fxml"));
        Scene NewAccountScene = new Scene(NewAccountRoot);

        primaryStage.setTitle("Create an Account");
        primaryStage.setScene(NewAccountScene);
        primaryStage.show();
    }
}
