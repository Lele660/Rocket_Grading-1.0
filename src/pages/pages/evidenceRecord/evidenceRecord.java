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
import javafx.scene.control.Button;
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
    
    public static void main() {
       ER();
    }
     @Override
    public void start(Stage stage) throws Exception {
        
    }
    //creates evidence record
    public static void ER(){
        primaryStage.setTitle("GridPane Experiment");
        
        Label labelOv = new Label("             ");
        labelOv.setStyle("-fx-background-color: white;");
        labelOv.setMaxWidth(Double.POSITIVE_INFINITY);
        labelOv.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelOh = new Label("          ");
        labelOh.setStyle("-fx-background-color: white;");
        labelOh.setMaxWidth(Double.POSITIVE_INFINITY);
        labelOh.setMaxHeight(Double.POSITIVE_INFINITY);
        
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
        
        Label labelU1 = new Label(" Unit 1 ");
        labelU1.setStyle("-fx-background-color: #112416 #112416;");
        labelU1.setTextFill(Color.web("#fffefe"));
        Label labelA1 = new Label(" A1 ");
        labelA1.setStyle("-fx-background-color: #112416 #112416;");
        labelA1.setTextFill(Color.web("#fffefe"));
        Label labelU2 = new Label(" Unit 2 ");
        labelU2.setStyle("-fx-background-color: #112416 #112416;");
        labelU2.setTextFill(Color.web("#fffefe"));
        Label labelA2 = new Label(" A2 ");
        labelA2.setStyle("-fx-background-color: #112416 #112416;");
        labelA2.setTextFill(Color.web("#fffefe"));
        Label labelU3 = new Label(" Unit 3 ");
        labelU3.setStyle("-fx-background-color: #112416 #112416;");
        labelU3.setTextFill(Color.web("#fffefe"));
        Label labelA3 = new Label(" A3 ");
        labelA3.setStyle("-fx-background-color: #112416 #112416;");
        labelA3.setTextFill(Color.web("#fffefe"));
        
        Label labelB = new Label("  ");
        labelB.setStyle("-fx-background-color: grey;");
        labelB.setMaxWidth(Double.POSITIVE_INFINITY);
        labelB.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelB1 = new Label("  ");
        labelB1.setStyle("-fx-background-color: grey;");
        labelB1.setMaxWidth(Double.POSITIVE_INFINITY);
        labelB1.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelB2 = new Label("  ");
        labelB2.setStyle("-fx-background-color: grey;");
        labelB2.setMaxWidth(Double.POSITIVE_INFINITY);
        labelB2.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelB3 = new Label("  ");
        labelB3.setStyle("-fx-background-color: grey;");
        labelB3.setMaxWidth(Double.POSITIVE_INFINITY);
        labelB3.setMaxHeight(Double.POSITIVE_INFINITY);
        Label labelB4 = new Label("  ");
        labelB4.setStyle("-fx-background-color: grey;");
        labelB4.setMaxWidth(Double.POSITIVE_INFINITY);
        labelB4.setMaxHeight(Double.POSITIVE_INFINITY);
        
        GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true);
        gridPane.add(labelOv, 0, 1, 2, 29);
        gridPane.add(labelOh, 1, 0, 30, 2);
       
        gridPane.add(labelU1, 6, 2, 1, 1);
        gridPane.add(labelB, 7, 2, 1, 28);
        gridPane.add(labelA1, 8, 2, 1, 1);
        gridPane.add(labelB1, 9, 2, 1, 28);
        gridPane.add(labelU2, 10, 2, 1, 1);
        gridPane.add(labelB2, 11, 2, 1, 28);
        gridPane.add(labelA2, 12, 2, 1, 1);
        gridPane.add(labelB3, 13, 2, 1, 28);
        gridPane.add(labelU3, 14, 2, 1, 1);
        gridPane.add(labelB4, 15, 2, 1, 28);
        gridPane.add(labelA3, 16, 2, 1, 1);
        
        //adds levels and level spacers to gridPane
        gridPane.add(labelR, 2, 4, 1, 1);
        gridPane.add(labelE, 2, 5, 20, 1);
        gridPane.add(label_1, 2, 6, 1, 1);
        gridPane.add(labelE1, 2, 7, 20, 1);
        gridPane.add(label1, 2, 8, 1, 1);
        gridPane.add(labelE2, 2, 9, 20, 1);
        gridPane.add(label1_, 2, 10, 1, 1);
        gridPane.add(labelE3, 2, 11, 20, 1);
        gridPane.add(label_2, 2, 12, 1, 1);
        gridPane.add(labelE4, 2, 13, 20, 1);
        gridPane.add(label2, 2, 14, 1, 1);
        gridPane.add(labelE5, 2, 15, 20, 1);
        gridPane.add(label2_, 2, 16, 1, 1);
        gridPane.add(labelE6, 2, 17, 20, 1);
        gridPane.add(label_3, 2, 18, 1, 1);
        gridPane.add(labelE7, 2, 19, 20, 1);
        gridPane.add(label3, 2, 20, 1, 1);
        gridPane.add(labelE8, 2, 21, 20, 1);
        gridPane.add(label3_, 2, 22, 1, 1);
        gridPane.add(labelE9, 2, 23, 20, 1);
        gridPane.add(label_4, 2, 24, 1, 1);
        gridPane.add(labelE10, 2, 25, 20, 1);
        gridPane.add(label4, 2, 26, 1, 1);
        gridPane.add(labelE11, 2, 27, 20, 1);
        gridPane.add(label4_, 2, 28, 1, 1);
        gridPane.add(labelE12, 2, 29, 20, 1);
        
        
        Scene scene = new Scene(gridPane, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
//    public void start(Stage primaryStage) {
//          BorderPane root = new BorderPane();
//          Label label = new Label("Some\ntext");
//          //label.setGraphic(new ImageView(getClass().getResource("/images/Folder-icon.png").toExternalForm()));
//          label.setMaxWidth(Double.POSITIVE_INFINITY);
//          label.setMaxHeight(Double.POSITIVE_INFINITY);
//          label.setStyle("-fx-border-color: blue;");
//          root.setCenter(label);
////          contentDisplayBox.getItems().addAll(ContentDisplay.values());
////          contentDisplayBox.getSelectionModel().select(ContentDisplay.LEFT);
////          label.contentDisplayProperty().bind(contentDisplayBox.valueProperty());
////          label.alignmentProperty().bind(alignmentBox.valueProperty());
////          label.textAlignmentProperty().bind(textAlignmentBox.valueProperty());
//          GridPane ctrls = new GridPane();
//          ctrls.setHgap(5);
//          ctrls.setVgap(5);
//          ctrls.setPadding(new Insets(10));
//          ctrls.addRow(0, new Label("Content display:"), new Label("Alignment:"), new Label("Text Alignment:"));
////          ctrls.addRow(1,  contentDisplayBox, alignmentBox, textAlignmentBox);
//        Scene scene = new Scene(ctrls, 1200, 900);
//          primaryStage.setScene(scene);
//          primaryStage.show();
//    }

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
