/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author lelezhao
 */
public class Student {
    private String firstName;
    private String lastName;
    private double grade;
    
    
   public Student(String first, String last, double grade){
       this.setFirstName(first);
       this.setLastName(last);
       this.setGrade(grade);
       
   }
   
   public void setGrade(double n){
       this.grade = n;
   }
   public double getGrade(){
       return this.grade;
   }
   public void setFirstName(String first){
       this.firstName=first;
   }
   public void setLastName(String last){
       this.lastName = last;
   }
   public String getLastName(){
       return this.lastName;
   }
   public String getFirstName(){
       return this.firstName;
   }
  
}
