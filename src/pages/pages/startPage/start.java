/*
 * opens start page 
 * mainly used for testing
 */
package pages.startPage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class start extends Application{
    public static void main(String[] args) {
       launch(args);
    }
    @Override
    //opens start page 
    //mainly used for testing 
    public void start(Stage primaryStage) throws Exception {
        Parent hRoot = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        Scene hScene = new Scene(hRoot);

        primaryStage.setTitle("Start Page");
        primaryStage.setScene(hScene);
        primaryStage.show();

    }
}
