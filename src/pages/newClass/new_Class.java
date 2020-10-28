/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class new_Class extends Application{
    public static void main(String[] args){
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent newClassRoot = FXMLLoader.load(getClass().getResource("createClass.fxml"));
        Scene newClassScene = new Scene(newClassRoot);

        primaryStage.setTitle("Creating Class");
        primaryStage.setScene(newClassScene);
        primaryStage.show();
    }
}
