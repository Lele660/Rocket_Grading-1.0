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
    private ArrayList<Student> studentList = new ArrayList<Student> ();
    private ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
    
    public User(String name, String className, ArrayList<String> students, ArrayList<String> assignments){
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
    
    
    
    
    
    
}
