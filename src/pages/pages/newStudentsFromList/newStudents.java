/*
 * opens new students page 
 * mainly used for testing
 */
package pages.newStudentsFromList;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class newStudents extends Application{
    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    //opens adding students screen
    //mainly used for testing
    public void start(Stage primaryStage) throws Exception {
        Parent addingStudentsRoot = FXMLLoader.load(getClass().getResource("addStudents.fxml"));
        Scene addingStudentsScene = new Scene(addingStudentsRoot);
        primaryStage.setTitle("New Students");
        primaryStage.setScene(addingStudentsScene);
        primaryStage.show();
    }
}
