/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.evidenceRecord;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class evidenceRecord extends Application{
    public static void main(String[] args) {
       launch(args);
    }
     @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GridPane Experiment");
        
        Label labelR = new Label("       R       ");
        labelR.setStyle("-fx-background-color: #112416 #112416;");
        labelR.setTextFill(Color.web("#fffefe"));
        Label label_1 = new Label("       1-      ");
        label_1.setStyle("-fx-background-color: #112416 #112416;");
        label_1.setTextFill(Color.web("#fffefe"));
        Label label1 = new Label("       1       ");
        label1.setStyle("-fx-background-color: #112416 #112416;");
        label1.setTextFill(Color.web("#fffefe"));
        Label label1_ = new Label("      1+      ");
        label1_.setStyle("-fx-background-color: #112416 #112416;");
        label1_.setTextFill(Color.web("#fffefe"));
        Label label_2 = new Label("       2-      ");
        label_2.setStyle("-fx-background-color: #112416 #112416;");
        label_2.setTextFill(Color.web("#fffefe"));
        Label label2 = new Label("       2       ");
        label2.setStyle("-fx-background-color: #112416 #112416;");
        label2.setTextFill(Color.web("#fffefe"));
        Label label2_ = new Label("      2+      ");
        label2_.setStyle("-fx-background-color: #112416 #112416;");
        label2_.setTextFill(Color.web("#fffefe"));
        Label label_3 = new Label("       3-      ");
        label_3.setStyle("-fx-background-color: #112416 #112416;");
        label_3.setTextFill(Color.web("#fffefe"));
        Label label3 = new Label("       3       ");
        label3.setStyle("-fx-background-color: #112416 #112416;");
        label3.setTextFill(Color.web("#fffefe"));
        Label label3_ = new Label("      3+      ");
        label3_.setStyle("-fx-background-color: #112416 #112416;");
        label3_.setTextFill(Color.web("#fffefe"));
        Label label_4 = new Label("       4-      ");
        label_4.setStyle("-fx-background-color: #112416 #112416;");
        label_4.setTextFill(Color.web("#fffefe"));
        Label label4 = new Label("       4       ");
        label4.setStyle("-fx-background-color: #112416 #112416;");
        label4.setTextFill(Color.web("#fffefe"));
        Label label4_ = new Label("      4+      ");
        label4_.setStyle("-fx-background-color: #112416 #112416;");
        label4_.setTextFill(Color.web("#fffefe"));
        Label labelE = new Label("");
        Label labelE1 = new Label("");
        Label labelE2 = new Label("");
        Label labelE3= new Label("");
        Label labelE4 = new Label("");
        Label labelE5 = new Label("");
        Label labelE6 = new Label("");
        Label labelE7 = new Label("");
        Label labelE8 = new Label("");
        Label labelE9 = new Label("");
        Label labelE10 = new Label("");
        Label labelE11 = new Label("");
        Label labelE12 = new Label("");
        Label labelE13 = new Label("      ");
        labelE13.setStyle("-fx-background-color: #112416 #112416;");
        Label labelU1 = new Label(" Unit 1 ");
        labelU1.setStyle("-fx-background-color: #112416 #112416;");
        labelU1.setTextFill(Color.web("#fffefe"));
        labelU1.setRotate(270);
        Label labelA1 = new Label(" A1 ");
        labelA1.setStyle("-fx-background-color: #112416 #112416;");
        labelA1.setTextFill(Color.web("#fffefe"));
        labelA1.setRotate(270);
        Label labelU2 = new Label(" Unit 2 ");
        labelU2.setStyle("-fx-background-color: #112416 #112416;");
        labelU2.setTextFill(Color.web("#fffefe"));
        labelU2.setRotate(270);
        Label labelA2 = new Label(" A2 ");
        labelA2.setStyle("-fx-background-color: #112416 #112416;");
        labelA2.setTextFill(Color.web("#fffefe"));
        labelA2.setRotate(270);
        Label labelU3 = new Label(" Unit 3 ");
        labelU3.setStyle("-fx-background-color: #112416 #112416;");
        labelU3.setTextFill(Color.web("#fffefe"));
        labelU3.setRotate(270);
        Label labelA3 = new Label(" A3 ");
        labelA3.setStyle("-fx-background-color: #112416 #112416;");
        labelA3.setTextFill(Color.web("#fffefe"));
        labelA2.setRotate(270);
        Label labelB = new Label("");
        labelB.setRotate(270);
        Label labelB1 = new Label("");
        labelB1.setRotate(270);
        Label labelB2 = new Label("");
        labelB2.setRotate(270);
        Label labelB3 = new Label("");
        labelB3.setRotate(270);
        Label labelB4 = new Label("");
        labelB4.setRotate(270);
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        gridPane.add(labelE13, 2, 0, 1, 1);
        
        gridPane.add(labelU1, 6, 1, 1, 1);
        gridPane.add(labelB, 7, 1, 1, 1);
        gridPane.add(labelA1, 8, 1, 1, 1);
        gridPane.add(labelB1, 9, 1, 1, 1);
        gridPane.add(labelU2, 10, 1, 1, 1);
        gridPane.add(labelB2, 11, 1, 1, 1);
        gridPane.add(labelA2, 12, 1, 1, 1);
        gridPane.add(labelB3, 13, 1, 1, 1);
        gridPane.add(labelU3, 14, 1, 1, 1);
        gridPane.add(labelB4, 15, 1, 1, 1);
        gridPane.add(labelA3, 16, 1, 1, 1);
        
        gridPane.add(labelR, 2, 3, 1, 1);
        gridPane.add(labelE, 2, 4, 5, 1);
        gridPane.add(label_1, 2, 5, 1, 1);
        gridPane.add(labelE1, 2, 6, 5, 1);
        gridPane.add(label1, 2, 7, 1, 1);
        gridPane.add(labelE2, 2, 8, 5, 1);
        gridPane.add(label1_, 2, 9, 1, 1);
        gridPane.add(labelE3, 2, 10, 5, 1);
        gridPane.add(label_2, 2, 11, 1, 1);
        gridPane.add(labelE4, 2, 12, 5, 1);
        gridPane.add(label2, 2, 13, 1, 1);
        gridPane.add(labelE5, 2, 14, 5, 1);
        gridPane.add(label2_, 2, 15, 1, 1);
        gridPane.add(labelE6, 2, 16, 5, 1);
        gridPane.add(label_3, 2, 17, 1, 1);
        gridPane.add(labelE7, 2, 18, 5, 1);
        gridPane.add(label3, 2, 19, 1, 1);
        gridPane.add(labelE8, 2, 20, 5, 1);
        gridPane.add(label3_, 2, 21, 1, 1);
        gridPane.add(labelE9, 2, 22, 5, 1);
        gridPane.add(label_4, 2, 23, 1, 1);
        gridPane.add(labelE10, 2, 24, 5, 1);
        gridPane.add(label4, 2, 25, 1, 1);
        gridPane.add(labelE11, 2, 26, 5, 1);
        gridPane.add(label4_, 2, 27, 1, 1);
        gridPane.add(labelE12, 2, 28, 5, 1);

        Scene scene = new Scene(gridPane, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

     /*@Override
     //opens evidence record page 
     //mainly used for testing
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Evidence Record");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("eRPage.fxml"));
        Scene homeScene = new Scene(homeRoot);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }*/
}
