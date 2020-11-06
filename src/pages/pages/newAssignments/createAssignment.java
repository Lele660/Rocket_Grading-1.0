/*
 * opens new assignment page 
 * mainly used for testing
 */
package pages.newAssignments;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lelezhao
 */

public class createAssignment extends Application{
    public static void main(String[] args){
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent newClassRoot = FXMLLoader.load(getClass().getResource("Create_Assignment.fxml"));
        Scene newClassScene = new Scene(newClassRoot);

        primaryStage.setTitle("Creating Assignment");
        primaryStage.setScene(newClassScene);
        primaryStage.show();
    }
}
