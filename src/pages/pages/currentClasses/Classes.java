/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.currentClasses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class Classes extends Application{
    public static void main(String[] args) {
        launch(args);
    }
     @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Classes");
        
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Menu 1");
        MenuItem menuItem1 = new MenuItem("Item 1");
        MenuItem menuItem2 = new MenuItem("Item 2");

        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        VBox vBox = new VBox(menuBar);
        menuBar.getMenus().add(menu1);
        
        Scene scene = new Scene(vBox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        menuItem1.setOnAction(e -> {
            System.out.println("Menu Item 1 Selected");
        });
    }
}
