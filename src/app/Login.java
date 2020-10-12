/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 *
 * @author lelezhao
 */
public class Login extends Application {
    
    @Override
    public void init() throws Exception{
        
    }

    @Override
    public void start(Stage login) throws Exception {
        login.setTitle("login");
        login.setHeight(1000);
        login.setWidth(3000);
        login.show(); 
    }
    
    @Override
    public void stop()throws Exception{
        
    }
    
}
