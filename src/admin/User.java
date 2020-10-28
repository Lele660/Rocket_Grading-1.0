/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.ArrayList;
import admin.Student;
import admin.Assignment;

/**
 *
 * @author lelezhao
 */


/*
everyone who registered is a user 
attributes:
name;
class code;
student list;
assignment list;
*/
public class User {
    private String name;
    private String className;
    private int userId;
    private ArrayList<Student> studentList = new ArrayList<Student> ();
    private ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
    
    public User(String name, String className,int userId, ArrayList<String> students, ArrayList<String> assignments){
        this.setName(name);         
    }
    public User(String name){
        this.setName(name);
        
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    public void setClassName(String className){
        this.className = className;
    }
    public void addStudentList(Student a){
        this.studentList.add(a);
    }
    public void addAssignment(Assignment a){
        this.assignmentList.add(a);
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getClassName(){
        return this.className;
    }
    
    public ArrayList<Student> getStudentList(){
        return this.studentList;
    }
    public ArrayList<Assignment> getAssignmentList(){
        return this.assignmentList;
    }
    
    public void setUserId(int userid){
        this.userId=userid;
    }
    public int getUserId(){
        return this.userId;
    }
    
    
    
}
