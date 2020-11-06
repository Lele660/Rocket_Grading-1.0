/*
 * opens class list page 
 * mainly used for testing
 */
package pages.classList;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class classList extends Application{
    public static void main(String[] args) {
       launch(args);
    }

     @Override
     //opens home page 
     //mainly used for testing
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Class List");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("classListPage.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
}
