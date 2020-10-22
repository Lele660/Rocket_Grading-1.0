package pCreateAccount;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
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
 * @author vanessa
 */
public class pCreatingAccount extends Application {
    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent pNewAccountRoot = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene pNewAccountScene = new Scene(pNewAccountRoot);

        primaryStage.setTitle("Create an Account");
        primaryStage.setScene(pNewAccountScene);
        primaryStage.show();
    }
}
