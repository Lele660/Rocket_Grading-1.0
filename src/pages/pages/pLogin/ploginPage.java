/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.pLogin;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vanes
 */
public class ploginPage extends Application{
    public static void main(String[] args) {
       launch(args);
    }
     @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sign in");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("pLogin.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
}
