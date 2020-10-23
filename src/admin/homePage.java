/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.homePage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class homePage extends Application{
    public static void main(String[] args) {
       launch(args);
    }
    
     @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Home");
        VBox homeRoot= new VBox();
        MenuItem item1=new MenuItem("taco");
        MenuItem item2=new MenuItem("burrito");
        Node node=null;
        
        MenuButton menuButton= new MenuButton("Food", node, item1, item2);
        
        homeRoot.getChildren().addAll(menuButton);
        
        //Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeRoot);

       
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
}
