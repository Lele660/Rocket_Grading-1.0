/*
 * opens evidence record tab page 
 * mainly used for testing
 */
package pages.evidenceRecordTab;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class evidenceRecord extends Application{
    public static void main(String[] args) {
       launch(args);
    }
    
     @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Evidence Record Tab");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("eRTabPage.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
    
}
