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
public class Student {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;

    
    public Student(String n, String d, int num){
        this.firstName = new SimpleStringProperty(n);
        this.lastName = new SimpleStringProperty(d);
        this.id = new SimpleIntegerProperty(num);
        this.name = new SimpleStringProperty(firstName.get() + " " + lastName.get());
   
    }
     public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String n) {
        firstName.set(n);
    }
        
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String name) {
        lastName.set(name);
    }
    public int getId(){
        return id.get();
    }
    public void setId(int n){
        id.set(n);
    }
    
    public String getName(){
        return name.get();
    }
    
    @Override
    public String toString(){
        return this.name.get();
    }
}
