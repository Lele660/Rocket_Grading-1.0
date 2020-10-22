/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author vanes
 */
public class HomePage {
    public static void main(String[] args) {
       launch(args);
    }
    
    //@Override
    public void start(Stage primaryStage) throws Exception {
        Parent pClassHomeRoot = FXMLLoader.load(getClass().getResource("ClassHome.fxml"));
        Scene pClassHomeScene = new Scene(pClassHomeRoot);

        primaryStage.setTitle("Class Home");
        primaryStage.setScene(pClassHomeScene);
        primaryStage.show();
    }
}
