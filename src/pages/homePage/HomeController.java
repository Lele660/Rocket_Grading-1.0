/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.homePage;

import static LoginPage.LoginController.loggerId;
import admin.JdbcDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
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
    @FXML 
    ComboBox<String> comboClasses;
    ArrayList<String> classList = new ArrayList<>();
    ObservableList<String> comboItems = FXCollections.observableArrayList();
    public static int counter;
    public static int CLASS_ID;
    
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/login/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    public void classes (ActionEvent event, Stage tertiaryStage) throws SQLException, IOException {
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
        
//        for(int i=0; i<=pages.files.info.C.length(); i++){
//             
//        }
        
        Parent cRoot = FXMLLoader.load(getClass().getResource("/pages/homeClass/homeClassPage.fxml"));
        Scene cScene = new Scene(cRoot);
        
        tertiaryStage.setTitle("Select Class");
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
        try {
            displayClasses();
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboClasses.setItems(comboItems);
        
    }    
    
    public void displayClasses() throws SQLException {

        try {
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "select * from Rocket_Grading.Class where User_Id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1, loggerId);
            //System.out.println(loggerId);
            ResultSet rs = statement.executeQuery();

            //find row number in the table 
            int count = 0;
            while (rs.next()) {
                String comboItem = rs.getString("Class_code") + " " + rs.getString("Class_Name");
                comboItems.add(comboItem);
                count++;
            }    
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }
    
    
    
    public void selectClass(ActionEvent event){
        String s = comboClasses.getValue();
        String sCode = s.substring(0, s.indexOf(" "));
        String sName = s.substring(s.indexOf(" ")+1);
        System.out.println(sName);
        System.out.println(sCode);
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "select * from Rocket_Grading.Class where Class_code = ? and User_Id = ? and Class_Name = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            
            statement.setString(1,sCode);
            statement.setInt(2,loggerId);
            statement.setString(3,sName);
          
            ResultSet rs = statement.executeQuery();
            
            if(!rs.next()){
                System.out.println("something is wrong");
            }
            else{
                CLASS_ID = rs.getInt("Class_Id");
                System.out.println(CLASS_ID);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        
    }
}
    
