/*
 * opens home class page 
 * mainly used for testing
 */
package pages.homeClass;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class homeClass extends Application{
    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    //sets screen to home screen (class mainly used for testing)
    public void start(Stage primaryStage) throws Exception {
        Parent classHomeRoot = FXMLLoader.load(getClass().getResource("homeClassPage.fxml"));
        Scene classHomeScene = new Scene(classHomeRoot);

        primaryStage.setTitle(" Class Home");
        primaryStage.setScene(classHomeScene);
        primaryStage.show();
    }
}
