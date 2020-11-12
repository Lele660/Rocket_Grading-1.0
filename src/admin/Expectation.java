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
public class Expectation {
    private final SimpleStringProperty name;
    private final SimpleStringProperty des;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty mark;
    private final SimpleStringProperty display;
 
    
    public Expectation(String n, int d, String t){
        this.name = new SimpleStringProperty(n);
        this.id = new SimpleIntegerProperty(d);
        this.des = new SimpleStringProperty(t);
        this.mark = new SimpleStringProperty("0");
        this.display = new SimpleStringProperty(name.get() + "\n" +  des.get());
    }
    public Expectation(String n, int d, String t, String m){
        this.name = new SimpleStringProperty(n);
        this.id = new SimpleIntegerProperty(d);
        this.des = new SimpleStringProperty(t); 
        this.mark = new SimpleStringProperty(m);
        this.display = new SimpleStringProperty(name.get() + "\n" +  des.get());
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
    
    public String getDes() {
        return des.get();
    }
    public void setDes(String n) {
        des.set(n);
    }
    public void setMark(String m){
        mark.set(m);
    }
    public String getMark(){
        return mark.get();
    }
    public String getDisplay(){
        return display.get();
    }
    public void setDisplay(String n){
        display.set(n);
    }
}
