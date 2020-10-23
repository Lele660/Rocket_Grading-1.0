/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.homePage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author vanessa
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    Button classes;
    @FXML
    Button createClass;
    @FXML
    Button signOut;
    
    
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/login/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    public void classes (ActionEvent event) throws SQLException, IOException {
//        tertiaryStage.setTitle("ListView Experiment 1");
//
//        ListView listView = new ListView();
//        listView.getItems().addAll(pages.ArrayLists.info.classes);
//        Button button = new Button("Read Selected Value");
//
//        
//        ObservableList selectedIndices = listView.getSelectionModel().getSelectedIndices();
//
//        for(Object o : selectedIndices){
//            System.out.println("o = " + o + " (" + o.getClass() + ")");
//        }
//        
//        VBox vbox = new VBox(listView, button);
//
//        Scene scene = new Scene(vbox, 300, 120);
//        tertiaryStage.setScene(scene);
//        tertiaryStage.show();
    
//        primaryStage.setTitle("ListView Experiment 1");
//        ListView listView = new ListView();
//        listView.getItems().addAll(pages.ArrayLists.info.classes);
//        HBox hbox = new HBox(listView);
//        Scene scene = new Scene(hbox, 300, 120);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        ComboBox classesComboBox = new ComboBox();
//        classesComboBox.getItems().add
        
        for(int i=0; i<=pages.files.info.C.length(); i++){
             
        }
        
        Parent cRoot = FXMLLoader.load(getClass().getResource("/pages/homeClass/homeClassPage.fxml"));
        Scene cScene = new Scene(cRoot);
        Stage tertiaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        tertiaryStage.setTitle("Class Home");
        tertiaryStage.setScene(cScene);
        tertiaryStage.show();
    }
    public void createClass (ActionEvent event) throws SQLException, IOException {
        Parent cCRoot = FXMLLoader.load(getClass().getResource("/pages/newClass/createClass.fxml"));
        Scene cCScene = new Scene(cCRoot);
        Stage fourthStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fourthStage.setTitle("Class Home");
        fourthStage.setScene(cCScene);
        fourthStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
