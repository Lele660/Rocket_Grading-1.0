/*
 * Controlls classListPage.fxml
 * when buttons are pressed different things happen
 */

package classList;

import static Assignments.AssignmentPageController.ASSIGNMENT_LIST;
import static LoginPage.LoginController.loggerId;
import static LoginPage.LoginController.loggerUsername;
import static LoginPage.LoginController.showAlert;
import admin.JdbcDao;
import admin.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static pages.homePage.HomeController.CLASS_ID;
import pages.newAssignment.Assignment_Expectation;
import static Assignments.AssignmentPageController.getAssignments;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import admin.Assignment;
import admin.Assignment_Grade;
//import ClassListPageController.Student1;
import static java.lang.Math.E;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.scene.control.cell.MapValueFactory;
import static javafx.scene.input.KeyCode.E;

/**
 * FXML Controller class
 *
 * @author vanessa
 */
public class ClassListPageController2 implements Initializable {
    @FXML
    Button signout;
    @FXML
    Button home;
    @FXML
    Button assignments;
    @FXML
    Button evidenceRecord;
    @FXML
    Button btnUnenroll;
    @FXML
    ScrollPane pane;
    @FXML
    TableView<Student1> table;
    @FXML 
    TableColumn col;
    @FXML 
    TableColumn col_assign;
    @FXML 
    TableColumn col_name;
    
    
//    VBox box;
     //brings user to login screen where they can login again if they wish
    public static ObservableList<String> STUDENT_NAME = FXCollections.observableArrayList();
    public static ObservableList<Student> STUDENT_LIST = FXCollections.observableArrayList();
    public static ArrayList<Integer> STUDENT_ID = new ArrayList<>();
    //public static ObservableList GRADES = FXCollections.observableArrayList();
    public static ObservableList<Integer> ASSIGNMENT_MARK_ID = FXCollections.observableArrayList();
    // all the grade ids for one student 
    //public static ObservableList<Integer> allIdForOne = FXCollections.observableArrayList();
    public static Map<Student,ObservableList<String>> Grade_Map = new HashMap();
    // for tableview
    public static ObservableList<Mark> MARKS = FXCollections.observableArrayList();
    public static ObservableList<Student1> STUDENTS = FXCollections.observableArrayList();

    public static int SELECTED_STUDENT;
    public void signOut (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/LoginPage/login.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    public void home (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/homePage/home.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Sign In");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
     //brings user to the assignments screen
    public void assignments (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/Assignments/assignmentPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Assignments");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    //brings user to the evidence record tab screen
    public void evidenceRecord (ActionEvent event) throws SQLException, IOException {
        Parent lRoot = FXMLLoader.load(getClass().getResource("/pages/evidenceRecordTab/eRTabPage.fxml"));
        Scene lScene = new Scene(lRoot);
        Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        secondaryStage.setTitle("Evidence Record Tab");
        secondaryStage.setScene(lScene);
        secondaryStage.show();
        pages.files.info.logOut();
    }
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            retrieveStudents();
            //display();
        } catch (SQLException ex) {
            Logger.getLogger(ClassListPageController2.class.getName()).log(Level.SEVERE, null, ex);
        }

        // get all the asssignments and display as columns 
        
        getAssignments();
        //displayAssignments();
        getCell();
  
        //ObservableList<Integer> result = FXCollections.observableArrayList();
   
        
        
       
         //test what is inside the grade map
        //for(Student s : STUDENT_LIST){
            //System.out.println(Grade_Map);
            //System.out.println("map value is " + Grade_Map.get(STUDENT_LIST.get(0)));
        //}
            //System.out.println("map 2 " + Grade_Map.get(STUDENT_LIST.get(1)));
        

 
       
    }    
    
    public static void retrieveEnrollment()throws SQLException{
        
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql ="select * from Rocket_Grading.Enrollment where Class_Id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            //System.out.println("class id is " + CLASS_ID);
            statement.setInt(1,CLASS_ID);

            ResultSet queryResult = statement.executeQuery();
            if(queryResult==null){
                System.out.println("wrong");
                
            }else{
                // add all the student ids in the table to a static list
                while(queryResult.next()){
                    int id = queryResult.getInt("Student_id");
                    //System.out.println("student id is " + id);
                    STUDENT_ID.add(id);
                    
                }
            }
                 
        }catch(Exception e){
                e.printStackTrace();
                e.getCause();
            
                }
        //test
//        
//        System.out.println("number of terms " + STUDENT_ID.size());
//        for(int id:STUDENT_ID){
//            System.out.println(id);
//        }
    }
    
    public static void retrieveStudents() throws SQLException{
        retrieveEnrollment();
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            
            for(int i = 0; i<STUDENT_ID.size(); i++){
                String sql ="select * from Rocket_Grading.Student_info where Student_id = ?";
                PreparedStatement statement = database.prepareStatement(sql);
                statement.setInt(1,STUDENT_ID.get(i));
                ResultSet queryResult = statement.executeQuery();
                if(queryResult==null){
                    System.out.println("wrong");
           
                }else{
                // add all the student names in the table to a static list
                    while(queryResult.next()){
                        String fName = queryResult.getString("First_name");
                        String lName = queryResult.getString(("Last_name"));
                        int id = queryResult.getInt("Student_id");
                        //String name = fName + " " + lName;
                        STUDENT_LIST.add(new Student(fName,lName,id));    
                    }
                }
            }
         
        }catch(Exception e){
                e.printStackTrace();
                e.getCause();
         }
        /*
        testing
        */
//        for(Student s:STUDENT_LIST){
//            System.out.println(s.getFirstName());
//        }
//        
    }
    private void display() throws SQLException{
        retrieveStudents();
        pane.setContent(table);
        col_name.setCellValueFactory(
                new PropertyValueFactory<Student, String>("name"));

        //table.setItems(STUDENT_LIST);
        
        TableColumn<Map.Entry<Student, ObservableList>, String> column1 = new TableColumn<>("sample");
        column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Student, ObservableList>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Student, ObservableList>, String> p) {
                // this callback returns property for just one cell, you can't use a loop here
                // for first column we use key
                return new SimpleStringProperty(p.getValue().getKey().getName());
            }
        });
        
        TableColumn<Map.Entry<Student, ObservableList>, String> column2 = new TableColumn<>("sample2");
        column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Student, ObservableList>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Student, ObservableList>, String> p) {
                // this callback returns property for just one cell, you can't use a loop here
                // for first column we use key
                return new SimpleStringProperty((String) p.getValue().getValue().get(0));
            }
        });
        
        

       


    }
    
    public void unenroll(ActionEvent event) throws SQLException{
        Student chosen = (Student) table.getSelectionModel().getSelectedItem();
        int id = chosen.getId();
        try{
            
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "delete from Enrollment where Student_id = ? and Class_id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setInt(2,20);
            statement.executeUpdate();
            showAlert(Alert.AlertType.CONFIRMATION, "Congrats",
             "This person has been deleted successfully");
            
            //System.out.println("deleted sucessfully");
            table.getItems().remove(chosen);
            
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    
    public void displayAssignments(){
        for (Student s : STUDENT_LIST) {
            //System.out.println("student name is " + s.getName());
            MARKS = getAssignmentGradeId(s);
            //System.out.println("length " + MARKS.size());
            Student1 stu = new Student1 (s.getName(),MARKS);
            System.out.println(stu);
            STUDENTS.add(stu);
        }
        
        table = new TableView(STUDENTS);
        TableColumn<Student1, String> firstNameColumn = new TableColumn("name");
            firstNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        table.getColumns().add(firstNameColumn);
        
//        Callback<TableColumn.CellDataFeatures<Student1, String>, ObservableValue<String>> callBack = 
//                new Callback<TableColumn.CellDataFeatures<Student1, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student1, String> param) {
//                return param.getValue().map.containsKey(
//                        "ass"+Integer.toString((int)param.getTableColumn().getUserData()))
//                        ? new SimpleStringProperty(String.format("%.1f",100d*param.getValue().map.get(
//                            "ass"+Integer.toString((int)param.getTableColumn().getUserData()))))
//                        :new SimpleStringProperty("");
//            }
//        };
    }
    
    /**
     * get mark of the student of an assignment 
     * @param stId
     * @param asId 
     */
    public void retrieveMark(int stId, int asId){
        JdbcDao jdbc = new JdbcDao();
        Connection database = jdbc.getConnection();
        
        try{
            String sql = "SELECT * FROM Assignment_grade WHERE Student_id = ? AND Assignment_id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,stId);
            //System.out.println("student id: " + stId);
            statement.setInt(2,asId);
            //System.out.println("Assignment id: " + asId);
            ResultSet rs = statement.executeQuery();
            if(rs!= null){
                while(rs.next()){
                    int id = rs.getInt("Assignment_grade_id");
                    Assignment_Grade ag= new Assignment_Grade(rs.getString("Assignment_grade"),id,
                    (stId));
                    
                    //System.out.println("assignment grade id " + id);
                    GRADES.add(ag);
                }
            }else{
                System.out.println("no result from db");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    
    public void getCell(){
      
        int student_id=0;
        int assignment_id=0;
        int i = 0;
        while(i<STUDENT_LIST.size())
        {
            student_id = STUDENT_LIST.get(i).getId();
            for(int j =0; j<ASSIGNMENT_LIST.size();j++){
                assignment_id = ASSIGNMENT_LIST.get(j).getId();
                retrieveMark(student_id, assignment_id);
                
            } i++;
          
        }
        
        for(Student s:STUDENT_LIST){
            System.out.println("stduent name: " + s.getName());
        }
        
        //retrieveMark(STUDENT_LIST.get(0).getId(),ASSIGNMENT_LIST.get(1).getId());
        System.out.println("");
//        for (Object o:GRADES){
//            //System.out.println("here");
//            System.out.println("\n");
//            System.out.println(o);
//        }
    }
    
    public ObservableList<Mark> getAssignmentGradeId(Student s){
        ObservableList<Mark> result = FXCollections.observableArrayList();
        //ObservableList<Mark> marks = FXCollections.observableArrayList();
        
        JdbcDao jdbc = new JdbcDao();
        Connection database = jdbc.getConnection();
        
        try{
            String sql = "SELECT * FROM Assignment_grade WHERE Student_id = ? ";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,s.getId());
            //System.out.println("student id: " + stId);
           
            ResultSet rs = statement.executeQuery();
            if(rs!= null){
                while(rs.next()){
                    int id = rs.getInt("Assignment_grade_id");
                    int assId = rs.getInt("Assignment_id");
                    String mark = rs.getString("Assignment_grade");
                    String assName = getAssignmentName(assId);
                    Mark temp = new Mark(assName,mark);
                    result.add(temp);
                    //System.out.println("the Mark object " + temp.getMap());
                }
            }else{
                System.out.println("no result from db");
            }
            //Student1 tempS = new Student1(s.getName(),marks);
                    //System.out.println("the student bind is " + tempS.getMap());

            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        //System.out.println("size of result array " + result.size());
       return result;
        
    }
    
    /**
     * 
     * @param a assignment grade id 
     * @return the corresponding mark of this assignment
     */
//    public ObservableList getFinal(ObservableList list){
//        ObservableList<String> result = FXCollections.observableArrayList();
//        for(Object i:list){
//            String mark = "";
//        JdbcDao jdbc = new JdbcDao();
//        Connection database = jdbc.getConnection();
//        
//        try{
//            String sql = "SELECT * FROM Assignment_grade WHERE Assignment_grade_id = ? ";
//            PreparedStatement statement = database.prepareStatement(sql);
//            statement.setInt(1,(int)i);
//            //System.out.println("student id: " + stId);
//           
//            ResultSet rs = statement.executeQuery();
//            if(rs!= null){
//                while(rs.next()){
//                    mark = rs.getString("Assignment_grade");   
//                    result.add(mark);
//                   // System.out.println("assignment grade  " + mark);
//                }
//            }else{
//                System.out.println("no result from db");
//            }
//            
//        }catch(Exception e){
//            e.printStackTrace();
//            e.getCause();
//        }
//        }
//        //ObservableList<String> result = FXCollections.observableArrayList();
//        System.out.println("marks are " + result);
//        return result;    
//    }
//    
    

    public class Student1 {

        private final StringProperty name = new SimpleStringProperty();
        public StringProperty firstNameProperty(){return name;}
        public final ObservableList maps = FXCollections.observableArrayList();
        public final HashMap<String, ObservableList<HashMap>> map;

        public Student1(String fn,ObservableList list) {
            name.set(fn);
        
            map = new LinkedHashMap<>();
            map.put(fn,list);
        }
        public HashMap getMap(){
            return map;
        }
        @Override
        public String toString(){
            return " " + map;
        }
    }
    
    /**
     * stores map of assignment name and 
     */
    
    public class Mark {

        public final HashMap<String, String> map;

        public Mark(String an,String g) {
            map = new LinkedHashMap<>();
            map.put(an,g);         
        }
        public HashMap getMap(){
            return map;
        }
         @Override
        public String toString(){
            return " " + map;
        }
       
    }
    
    public String getAssignmentName(int assId){
        String result ="";
        JdbcDao jdbc = new JdbcDao();
        Connection database = jdbc.getConnection();
        
        try{
            String sql = "SELECT * FROM Assignment WHERE Assignment_Id = ? ";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,assId);
            //System.out.println("student id: " + stId);
           
            ResultSet rs = statement.executeQuery();
            if(rs!= null){
                while(rs.next()){
                    result = rs.getString("Assignment_Name");   
                    //System.out.println("assignment name  " + result);
                }
            }else{
                System.out.println("no result from db");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return result;
    }
    
    
    
    }

