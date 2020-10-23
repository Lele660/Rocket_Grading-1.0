/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.login;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author lelezhao
 */
public class login extends Application {
    public static void main(String[] args) {
       launch(args);
    }
    
    //onAction="#register"
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loginRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginRoot);

        primaryStage.setTitle("Login");
        primaryStage.setScene(loginScene);
        primaryStage.show();

    }
    
}
