/*
 * Controlls homeClassPage.fxml
 * when buttons are pressed different things happen
 */
package pages.homeClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pages.classListWithoutFXML.pageForClassList;

/**
 * FXML Controller class
 *
 * @author vanessa
 */
public class HomeClassPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button signOut;
    @FXML
    Button Home;
    @FXML
    Button classList;
    @FXML
    Button evidenceRecord;
    @FXML
    Button assignments;
    
    private TableView table = new TableView();
    public String cCode=pages.homePage.HomeController.classCode;
    ObservableList<String> data = FXCollections.observableArrayList();
    TableColumn nameCol = new TableColumn("Student Name");
    TableColumn gap = new TableColumn(" ");
    TableColumn assignmentCol = new TableColumn("Assignments");
    
    //brings user to login screen where they can login again if they wish
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/pLogin/pLogin.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
     //brings user to home screen where they can choose what to do next
    public void home (ActionEvent event) throws SQLException, IOException {
        Parent hRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene hScene = new Scene(hRoot);
        Stage tertiaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        tertiaryStage.setTitle("Home");
        tertiaryStage.setScene(hScene);
        tertiaryStage.show();
    }
    //brings user to the class list screen
    public void classList (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/classList/classListPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Class List");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
//        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(new Group());
//        stage.setTitle("Class List");
//        stage.setWidth(1500);
//        stage.setHeight(900);
// 
//        final Label label = new Label("Class List");
//        label.setFont(new Font("Arial", 20));
// 
//        table.setEditable(true);
// 
//        nameCol.setPrefWidth(200);
//        nameCol.setCellValueFactory(
//                new PropertyValueFactory<pageForClassList.Person, String>("name"));
//        gap.setPrefWidth(10);
//        assignmentCol.setPrefWidth(900);
//        int spot=0;
        // System.out.println();
        
//        while(spot<=pages.files.info.A.length()){
//            String comboItem =pages.files.info.getAssignment(spot, cCode);
//            if(comboItem == null){
//                spot++;
//            }else{
//                data.add(comboItem);
//                spot++;
//            }
//        }
//        String holder="";
//        for(int i=0; i<=pages.files.info.A.length(); i++){
//            table.getColumns().clear();
//            TableColumn<ObservableList, String> comboItem = new TableColumn<>(pages.files.info.getAssignment(spot, cCode));
//            //comboItem.
//            if(pages.files.info.getAssignment(spot, cCode) ==null){
//                spot++;
//            }else {
//                System.out.println(pages.files.info.getAssignment(spot, cCode));
//                spot++;
//                //TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
//                //comboItem.setCellValueFactory(cellData -> Bindings.createObjectBinding(() -> cellData.getValue().getFirstName()));
//                assignmentCol.getColumns().add(comboItem);
//                holder=pages.files.info.getAssignment(spot, cCode);
//            }
//        }
//        
//        
//        table.getColumns().addAll(nameCol, gap, assignmentCol);
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
// 
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
// 
//        stage.setScene(scene);
//        stage.show();
    }
    //brings user to the assignments screen
    public void assignments (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/Assignments/assignmentPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Assignments");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
     //brings user to the evidence record tab screen
    public void evidenceRecord (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/evidenceRecordTab/eRTabPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Evidence Record Tab");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
