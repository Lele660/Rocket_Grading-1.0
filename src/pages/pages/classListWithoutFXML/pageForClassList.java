/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.classListWithoutFXML;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * @author vanessa
 */
public class pageForClassList extends Application{
    
    private TableView table = new TableView();
    public String cCode=pages.homePage.HomeController.classCode;
    ObservableList<String> data = FXCollections.observableArrayList();
    TableColumn nameCol = new TableColumn("Student Name");
    TableColumn gap = new TableColumn(" ");
    TableColumn assignmentCol = new TableColumn("Assignments");
        
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException{
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(1500);
        stage.setHeight(900);
 
        final Label label = new Label("Class List");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        nameCol.setPrefWidth(200);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("name"));
        gap.setPrefWidth(10);
        assignmentCol.setPrefWidth(900);
        int spot=0;
        while(spot<=pages.files.info.A.length()){
             TableColumn<Person, String> comboItem = new TableColumn<>(pages.files.info.getAssignment(spot, cCode));
            if(comboItem == null){
                spot++;
            }else{
                spot++;
                assignmentCol.getColumns().add(comboItem);
            }
        }
        table.getColumns().addAll(nameCol, gap, assignmentCol);
//        for (int i = 0; i < pages.files.info.C.length() ; i++) {
//            final int index = i;
//            TableColumn<Person, String> ageValCol = new TableColumn<>(data.get(i));
//
//            // get data from list using index
//            ageValCol.setCellValueFactory(cellData -> Bindings.createObjectBinding(() -> cellData.getValue().getFirstName()));
//
//            nameCol.getColumns().add(ageValCol);
//        }
        
//        ObservableList<ObservableList> csvData = FXCollections.observableArrayList(); 

//         for(List<String> dataList : data) {
//             ObservableList<String> row = FXCollections.observableArrayList();
//            for( String rowData : dataList) {
//              row.add(rowData); 
//          }
//           cvsData.add(row); // add each row to cvsData
//        }
//
//        table.setItems(cvsData); // finally add data to tableview
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
    
     public static class Person {
 
        private final SimpleStringProperty name;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
 
        private Person(String fName, String lName, String email) {
            this.name = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }
 
        public String getFirstName() {
            return name.get();
        }
 
        public void setFirstName(String fName) {
            name.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}