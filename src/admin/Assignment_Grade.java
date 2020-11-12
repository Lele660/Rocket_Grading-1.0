/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lelezhao
 */
public class Assignment_Grade {
    private final SimpleStringProperty grade;
    private final SimpleIntegerProperty gradeId;
    private final SimpleIntegerProperty studentId;
        public Assignment_Grade(String g, int gId,int stuId){
            this.grade = new SimpleStringProperty(g);
            this.gradeId = new SimpleIntegerProperty(gId);
            this.studentId = new SimpleIntegerProperty(stuId);
        }
        
        public String getGrade(){
            return grade.get();
        }
        
        public int getGradeId(){
            return gradeId.get();
        }
        
         public int getStudentId(){
            return studentId.get();
        }
        
         public void setGrade(String g){
             this.grade.set(g);
         }
         public void setGradeId(int gi){
             this.gradeId.set(gi);
         }
         public void setStudentId(int si){
             this.studentId.set(si);
         }
         
    @Override
         public String toString(){
             return grade.get() + " (grade) and (Assignment grade id) " + gradeId.get();
         }
}