/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author 
 */
public class JdbcDao {
    public Connection database_link;
    
    public Connection getConnection() {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DATABASE_URL = "jdbc:mysql://localhost:3306/Rocket_Grading?serverTimezone=UTC";
        String DATABASE_USERNAME = "root";
        String DATABASE_PASSWORD = "12345678";
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            database_link = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        
        return database_link;

}
   
    public void connect(){
        JdbcDao jdbc2 = new JdbcDao();
        Connection conn = jdbc2.getConnection();
    }
   
    
    
    
    
    
    
}
