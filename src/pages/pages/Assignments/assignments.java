/*
 * opens assignment page 
 * mainly used for testing
 */
package pages.Assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class assignments extends Application{
    public static void main(String[] args) {
       launch(args);
    }
     @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Assignments");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("assignmentPage.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
    
}
