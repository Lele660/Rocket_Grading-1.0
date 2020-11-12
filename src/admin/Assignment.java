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
public class Assignment {
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleIntegerProperty id;
 
    
 
    
    public Assignment(String n, int d, String t){
        this.name = new SimpleStringProperty(n);
        this.id = new SimpleIntegerProperty(d);
        this.type = new SimpleStringProperty(t);
   
    }
     public String getName() {
        return name.get();
    }
    public void setFirstName(String n) {
        name.set(n);
    }
        
    public int getId() {
        return id.get();
    }
    public void setId(int n) {
        id.set(n);
    }
    
    public String getType() {
        return type.get();
    }
    public void setType(String n) {
        type.set(n);
    }
}
