/*
 * opens creating class page 
 * mainly used for testing
 */
package pages.newClass;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class newClass extends Application{
    public static void main(String[] args){
       launch(args);
    }
    
    @Override
    //opens creating class page
    //mainly used for testing
    public void start(Stage primaryStage) throws Exception {
        Parent newClassRoot = FXMLLoader.load(getClass().getResource("createClass.fxml"));
        Scene newClassScene = new Scene(newClassRoot);

        primaryStage.setTitle("Creating Class");
        primaryStage.setScene(newClassScene);
        primaryStage.show();
    }
}
