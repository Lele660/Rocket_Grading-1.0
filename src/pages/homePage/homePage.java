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
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class homePage extends Application{
    public static void main(String[] args) {
       launch(args);
    }
/*<MenuButton id="classes" fx:id="classes" alignment="CENTER" layoutX="700.0" layoutY="307.0" mnemonicParsing="false" prefHeight="80.0" prefWidth="130.0" style="-fx-background-color: #112416 #112416; -fx-border-radius: 0;" text="Classes" textAlignment="CENTER" textFill="#fffefe" AnchorPane.leftAnchor="425.0" AnchorPane.rightAnchor="825.0" AnchorPane.topAnchor="300.0">
            <font>
                <Font name="Apple Chancery" size="18.0" />
            </font>
            <items>
                <MenuItem mnemonicParsing="false" onAction="" text="1" />
                <MenuItem mnemonicParsing="false" onAction="" text="2" />
                <MenuItem mnemonicParsing="false" onAction="" text="3" />
            </items>
     </MenuButton>
*/
     @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Home");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
}
