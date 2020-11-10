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
        
        GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true);
        gridPane.add(labelOv, 0, 1, 2, 29);
        gridPane.add(labelOh, 1, 0, 30, 2);
        for(int i=6; i<17; i++){//fix the 17 to work with the database
            gridPane.add(new Button(), 1, 0); // column=1 row=0
            if(i%2==0){
                Label labelP = new Label((String.valueOf(i)));
                labelP.setStyle("-fx-background-color: #112416 #112416;");
                labelP.setTextFill(Color.web("#fffefe"));
                gridPane.add(labelP, i, 2, 1, 1);
            }else{
                Label label = new Label("  ");
                label.setStyle("-fx-background-color: grey;");
                label.setMaxWidth(Double.POSITIVE_INFINITY);
                label.setMaxHeight(Double.POSITIVE_INFINITY);
                gridPane.add(label, i, 2, 1, 1);
            }
            String test= String.valueOf(i);
        }
        
        
        
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
    //creates evidence record
    public static void ER(){
        
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
