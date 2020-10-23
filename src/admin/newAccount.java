/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newAccount;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class newAccount extends Application {
    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent NewAccountRoot = FXMLLoader.load(getClass().getResource("cA.fxml"));
        Scene NewAccountScene = new Scene(NewAccountRoot);

        primaryStage.setTitle("Create an Account");
        primaryStage.setScene(NewAccountScene);
        primaryStage.show();
    }
}
