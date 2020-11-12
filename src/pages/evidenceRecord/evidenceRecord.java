/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.evidenceRecord;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class evidenceRecord extends Application{
    
    static Stage primaryStage = new Stage();
    
    public static void main(String[] args) {
       launch(args);
       
    }
    @Override
    public void start(Stage stage) throws Exception {
//        Parent newClassRoot = FXMLLoader.load(getClass().getResource("eRCHart.fxml"));
//        Scene newClassScene = new Scene(newClassRoot);
//        primaryStage.setTitle("Creating Assignment");
//        primaryStage.setScene(newClassScene);
//        primaryStage.show();
        
    }
    //creates evidence record
    public void ER() throws Exception{
        primaryStage.setTitle("Evidence Record");
        
        Label labelOv = new Label("             ");//creates a border around chart
        labelOv.setStyle("-fx-background-color: white;");
        labelOv.setMaxWidth(Double.POSITIVE_INFINITY);
        labelOv.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelOh = new Label("          ");//creates a border around chart
        labelOh.setStyle("-fx-background-color: white;");
        labelOh.setMaxWidth(Double.POSITIVE_INFINITY);
        labelOh.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelInfo = new Label(" ");//edit to have student information
        
        
        //creates levels lables
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
        
        //creates spacers between levels(makes it easier to read)
        Label labelE = new Label("");
        labelE.setStyle("-fx-background-color: grey;");
        labelE.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE1 = new Label("");
        labelE1.setStyle("-fx-background-color: grey;");
        labelE1.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE1.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE2 = new Label("");
        labelE2.setStyle("-fx-background-color: grey;");
        labelE2.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE2.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE3= new Label("");
        labelE3.setStyle("-fx-background-color: grey;");
        labelE3.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE3.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE4 = new Label("");
        labelE4.setStyle("-fx-background-color: grey;");
        labelE4.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE4.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE5 = new Label("");
        labelE5.setStyle("-fx-background-color: grey;");
        labelE5.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE5.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE6 = new Label("");
        labelE6.setStyle("-fx-background-color: grey;");
        labelE6.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE6.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE7 = new Label("");
        labelE7.setStyle("-fx-background-color: grey;");
        labelE7.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE7.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE8 = new Label("");
        labelE8.setStyle("-fx-background-color: grey;");
        labelE8.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE8.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE9 = new Label("");
        labelE9.setStyle("-fx-background-color: grey;");
        labelE9.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE9.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE10 = new Label("");
        labelE10.setStyle("-fx-background-color: grey;");
        labelE10.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE10.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE11 = new Label("");
        labelE11.setStyle("-fx-background-color: grey;");
        labelE11.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE11.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelE12 = new Label("");
        labelE12.setStyle("-fx-background-color: grey;");
        labelE12.setMaxWidth(Double.POSITIVE_INFINITY);
        labelE12.setMaxHeight(Double.POSITIVE_INFINITY);
        
        GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true);
        gridPane.add(labelInfo, 0, 0, 1, 1);
        gridPane.add(labelOv, 0, 1, 4, 300);
        gridPane.add(labelOh, 1, 0, 300, 4);
        int i=7;
        int j=0;
        while(j<=15){//fix the 17 to work with the database
            Label labelP = new Label((String.valueOf(j))+"      ");//edit
            System.out.println(i-7);
            labelP.setStyle("-fx-background-color: #112416 #112416;");
            labelP.setTextFill(Color.web("#fffefe"));
            gridPane.add(labelP, i-1, 4, 1, 1);
            System.out.println(i-1);
            Label label = new Label("    ");
            label.setStyle("-fx-background-color: grey;");
            label.setMaxWidth(Double.POSITIVE_INFINITY);
            label.setMaxHeight(Double.POSITIVE_INFINITY);
            gridPane.add(label, i, 4, 1, 28);
            System.out.println(i);
            String test= String.valueOf(i);
            j++;
            System.out.println(i);
            System.out.println(" ");
            i+=2;
        }
        
        //adds levels and level spacers to gridPane
        gridPane.add(labelR, 4, 4, 1, 1);//row R
        gridPane.add(labelE, 4, 5, 100, 1);
        gridPane.add(label_1, 4, 6, 1, 1);//row 1-
        gridPane.add(labelE1, 4, 7, 100, 1);//row 1-/1
        gridPane.add(label1, 4, 8, 1, 1);//row 1
        gridPane.add(labelE2, 4, 9, 100, 1);//row 1/1+
        gridPane.add(label1_, 4, 10, 1, 1);//row 1+
        gridPane.add(labelE3, 4, 11, 100, 1);//row 1+/2-
        gridPane.add(label_2, 4, 12, 1, 1);//row 2-
        gridPane.add(labelE4, 4, 13, 100, 1);//row 2-/2
        gridPane.add(label2, 4, 14, 1, 1);//row 2
        gridPane.add(labelE5, 4, 15, 100, 1);//row 2/2+
        gridPane.add(label2_, 4, 16, 1, 1);//row 2+
        gridPane.add(labelE6, 4, 17, 100, 1);//row 2+/3-
        gridPane.add(label_3, 4, 18, 1, 1);//row 3-
        gridPane.add(labelE7, 4, 19, 100, 1);//row 3-/3
        gridPane.add(label3, 4, 20, 1, 1);//row 3
        gridPane.add(labelE8, 4, 21, 100, 1);//row 3/3+
        gridPane.add(label3_, 4, 22, 1, 1);//row 3+
        gridPane.add(labelE9, 4, 23, 100, 1);//row 3+/4-
        gridPane.add(label_4, 4, 24, 1, 1);//row 4-
        gridPane.add(labelE10, 4, 25, 100, 1);//row 4-/4
        gridPane.add(label4, 4, 26, 1, 1);//row 4
        gridPane.add(labelE11, 4, 27, 100, 1);//row 4/4+
        gridPane.add(label4_, 4, 28, 1, 1);//row 4+
        gridPane.add(labelE12, 4, 29, 100, 1);//row 4++
        
        Scene scene = new Scene(gridPane, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
