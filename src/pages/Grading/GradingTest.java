/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.Grading;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lelezhao
 * */

public class GradingTest extends Application{
    public static void main(String[] args) {
       launch(args);
    }

     @Override
     //opens home page 
     //mainly used for testing
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Grading Test");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("grading.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
}


