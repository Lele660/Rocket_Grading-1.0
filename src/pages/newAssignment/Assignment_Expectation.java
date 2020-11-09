/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.newAssignment;

import admin.JdbcDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lelezhao
 */
public class Assignment_Expectation {
    private final SimpleStringProperty name;
    private final SimpleStringProperty des;
    
    public Assignment_Expectation(String n, String d){
        this.name = new SimpleStringProperty(n);
        this.des = new SimpleStringProperty(d);
   
    }
     public String getName() {
        return name.get();
    }
    public void setFirstName(String n) {
        name.set(n);
    }
        
    public String getDes() {
        return des.get();
    }
    public void setDes(String descri) {
        des.set(descri);
    }
    
    
    }
    
        
    
    

