/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newAssignment;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author vanessa
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

