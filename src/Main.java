

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

/**
 *
 * @author lelezhao
 */
public class Main extends Application {
    public static void main(String[] args) {
       launch(args);
    }
    public void start(Stage primaryStage) throws Exception {
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/resources/fxml/login.fxml"));
        Scene loginScene = new Scene(loginRoot);


        primaryStage.setTitle("Home");
        primaryStage.setScene(loginScene);
        primaryStage.show();


    }
    
}
