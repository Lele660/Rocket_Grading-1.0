/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.Grading;

import static Assignments.AssignmentPageController.ASSIGNMENT_LIST;
import static Assignments.AssignmentPageController.SELECTED_ASSIGNMENT;
import admin.Expectation;
import admin.JdbcDao;
import admin.Student;
import admin.Assignment;
import admin.Assignment_Grade;
import classList.ClassListPageController2;
import static classList.ClassListPageController2.ASSIGNMENT_MARK_ID;
import static classList.ClassListPageController2.STUDENT_ID;
import static classList.ClassListPageController2.STUDENT_LIST;
import static classList.ClassListPageController2.retrieveStudents;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.stage.Stage;

/**
 *
 * @author lelezhao
 */
public class GradingController implements Initializable{
    @FXML 
    Button btnNext;
    @FXML
    Button btnHome;
    @FXML
    Button btnClass;
    @FXML
    Button btnPrevious;
    @FXML
    Label tfName;
    @FXML
    Label tfAname;
    @FXML 
    TableView tb;
    @FXML 
    TableColumn col_ex;
    @FXML
    TableColumn col_marks;
    @FXML
    ComboBox comboStudents;
    @FXML
    TextField tfMark;
    final ObservableList<Expectation> EXPECTATIONS = FXCollections.observableArrayList();
    final ObservableList<String> student_names = FXCollections.observableArrayList();
    public static Student SELECTED_STUDENT;
    private int grade_id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            retrieveStudents();
            //getGradeId();
        } catch (SQLException ex) {
            Logger.getLogger(GradingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SELECTED_STUDENT = STUDENT_LIST.get(0);
        initWindow(SELECTED_STUDENT,SELECTED_ASSIGNMENT);
        getGradeId();
        getExpectations();
        for (Expectation ex:EXPECTATIONS){
            System.out.println(ex);
        }
        System.out.println(EXPECTATIONS.size());
        try {
            display();
        } catch (Exception ex) {
            Logger.getLogger(GradingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        comboStudents.setItems(STUDENT_LIST);
        // when the marking page is open, automatically create a row in the Assignment_grade table, and everytime that it updates 
        //the mark would just be changed instead of inserted. 
        //initDB();
        
        
        //test 
       
        for(int o:ASSIGNMENT_MARK_ID){
            System.out.println("Assignment mark id is: " + o);
        }
    }
    
    public void display() throws Exception {
        //tb.refresh();
        //tb.getItems().clear();
        //tb.getItems().addAll(EXPECTATIONS);
        Expectation temp_ex;
        tb.setItems(EXPECTATIONS);
        col_ex.setCellValueFactory(
                new PropertyValueFactory<Expectation, String>("display"));
        col_marks.setCellValueFactory(
                new PropertyValueFactory<Expectation, String>("mark"));
        
        col_marks.setCellFactory(TextFieldTableCell.forTableColumn());
        col_marks.setOnEditCommit(new EventHandler<CellEditEvent<Expectation, String>>() {
            @Override
            public void handle(CellEditEvent<Expectation, String> event) {
                Expectation temp = event.getRowValue();
                temp.setMark(event.getNewValue());
                try {
                    updateMark(temp);
                    // to do, get local interface to update
                    temp.setMark(event.getNewValue());
                } catch (SQLException ex) {
                    System.out.println("something is terribly wrong");
                    //Logger.getLogger(GradingController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   
    public void getExpectations() {
        try {
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql = "select * from Rocket_Grading.Assignment_expectation where Assignment_grade_id = ? ";

            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,grade_id);
            System.out.println("assignment grade id of this person is " + getGradeId().getGradeId());
            //statement.setInt(2,s.getId());
        
            //System.out.println(SELECTED_ASSIGNMENT.getId());

            ResultSet rs = statement.executeQuery();
            if(rs==null){
                System.out.println("This assignment has no expectations");
            }else{
                while(rs.next()){
                    int id = rs.getInt("Expectation_id");
                    String name = rs.getString("Expectation_name");
                    String des = rs.getString("Expectation_description");
                    String mark = rs.getString("Expectation_grade");
                    System.out.println("expectation id: " + id);
                    EXPECTATIONS.add(new Expectation(name,id,des,mark));
                }
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        for(Expectation ex:EXPECTATIONS){
            
            System.out.println(ex.getId());
        }
    }
    
    public void retrieveEnrollment()throws SQLException{
        
        try{
            JdbcDao jdbc = new JdbcDao();
            Connection database = jdbc.getConnection();
            String sql ="select * from Rocket_Grading.Enrollment where Class_Id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            //System.out.println("class id is " + CLASS_ID);
            statement.setInt(1,0);
           

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
        //System.out.println("number of terms " + STUDENT_ID.size());
        for(int id:STUDENT_ID){
            //System.out.println(id);
        }
    }
    
    public void retrieveStudents() throws SQLException{
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
        for(Student s:STUDENT_LIST){
            String name = s.getName();
            student_names.add(name);
            //System.out.println(s.getFirstName());
        }
        
    }
//    public void goNext(ActionEvent event){
//        
//        
//    }
//    
//    public void goLast(ActionEvent event){
//        
//        
//    }
    
    public void selectStudent(ActionEvent event) throws IOException, Exception{
        // get the sleected student and pass in its student id 
        SELECTED_STUDENT = (Student)comboStudents.getValue();
       
        //SELECTED_STUDENT = STUDENT_LIST.get(0);
        initWindow(SELECTED_STUDENT,SELECTED_ASSIGNMENT);
        getGradeId();
        getExpectations();
        try {
            display();
        } catch (Exception ex) {
            Logger.getLogger(GradingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateMark(Expectation ex)throws SQLException{
       JdbcDao jdbc2 = new JdbcDao();
        Connection conn = jdbc2.getConnection();

        String query = "UPDATE Assignment_expectation SET Expectation_grade = ? WHERE Expectation_id = ?";

        try{
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,ex.getMark());
            //statement.setInt(2,grade_id);
            statement.setInt(2,ex.getId());
            statement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }   
    }



// after adding final mark, add the assignment grade id to the expectation table for each student as well
    public void updateFinal(ActionEvent event){
        JdbcDao jdbc2 = new JdbcDao();
        Connection conn = jdbc2.getConnection();
        String qry = "UPDATE Assignment_grade SET Assignment_grade = ? WHERE Assignment_grade_id = ?";

        try{
            PreparedStatement statement = conn.prepareStatement(qry);
            statement.setString(1,tfMark.getText());
            System.out.println("tf mark is " + tfMark.getText());
            statement.setInt(2,grade_id);
            statement.executeUpdate();
            System.out.println("did it");
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }   
    }
    
    /**
     * check if a database row has already been created for this student and assignment, if so, set the assignment_grade_id.
     * if not, create a new row in the Assignment_grade_id table
     */
    
//    public void initDB(){
//        JdbcDao jdbc2 = new JdbcDao();
//        Connection conn = jdbc2.getConnection();
//        String echo = "SELECT * from Assignment_grade WHERE Assignment_id = ? AND Student_id = ?";
//        //String query = "INSERT INTO Assignment_grade(Assignment_id, Student_id) VALUES(?,?)";
//        
//        try {
//            PreparedStatement statement = conn.prepareStatement(echo);
//            statement.setInt(1, SELECTED_ASSIGNMENT.getId());
//            statement.setInt(2, SELECTED_STUDENT.getId());
//            System.out.println("Selected assiment id " + SELECTED_ASSIGNMENT.getId());
//            System.out.println("Selected student id " + SELECTED_STUDENT.getId());
//            ResultSet rs = statement.executeQuery();
//            if (!rs.next()) {
//                System.out.println("got here");
//
//                //PreparedStatement statement1 = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//                //statement1.setInt(1, SELECTED_ASSIGNMENT.getId());
//                //statement1.setInt(2, SELECTED_STUDENT.getId());
//
//                //statement1.executeUpdate();
//                //ResultSet rs1 = statement1.getGeneratedKeys();
//                //if (rs1!=null) {
//                    //System.out.println("you created one");
//                    //grade_id = rs.getInt(1);
//                   // System.out.println("Grade id is " + grade_id);
//               // }
//            }else{
//                //if(rs.next()){
//                    grade_id = rs.getInt(1);
//                    
//                    System.out.println("It already exist");
//                    System.out.println("grade_id is " + grade_id);
//                //}
//               
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getCause();
//        }
//
//       
//        
//    }
    public void initWindow(Student s, Assignment a){
         tfName.setText( s.toString());
        //tfName.textProperty().bind(tfName.textProperty());
        //System.out.println("number of students " + STUDENT_LIST.size());
        tfAname.setText(a.getName());
        //System.out.println(SELECTED.getName());
    }
    
    /**
     * This function gets all info needed to get the assignment grade id 
     * @param stId
     * @param asId 
     */
   
    
    public Assignment_Grade getGradeId(){
        Assignment_Grade result = new Assignment_Grade("0",0,0);
         JdbcDao jdbc = new JdbcDao();
        Connection database = jdbc.getConnection();
        
        try{
            String sql = "SELECT * FROM Assignment_grade WHERE Student_id = ? AND Assignment_id = ?";
            PreparedStatement statement = database.prepareStatement(sql);
            statement.setInt(1,SELECTED_STUDENT.getId());
            //System.out.println("student id: " + stId);
            statement.setInt(2,SELECTED_ASSIGNMENT.getId());
            //System.out.println("Assignment id: " + asId);
            ResultSet rs = statement.executeQuery();
            if (rs .next()) {
                int id = rs.getInt("Assignment_grade_id");
                result = new Assignment_Grade(rs.getString("Assignment_grade"), id,
                        SELECTED_STUDENT.getId());
                //System.out.println("result returned is " + result);
                grade_id = id;
                System.out.println("assignment grade id (got from getGradeId) " + id);
                //GRADES.add(ag);

            } else {
                System.out.println("no result from db");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return result;
        
    }
    
    
 
}
    

    
    
    

