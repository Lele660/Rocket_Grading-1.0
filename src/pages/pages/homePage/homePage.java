/*
 * opens home page 
 * mainly used for testing
 */
package pages.homePage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class homePage extends Application{
    public static void main(String[] args) {
       launch(args);
    }

     @Override
     //opens home page 
     //mainly used for testing
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Home");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
}
