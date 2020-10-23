/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static javafx.application.Application.launch;

/**
 *
 * @author vanessa
 */
public class info {
    
     public static boolean logged;
     public static File aU = new File("Username.txt");
     public static File aP = new File("Passwords.txt");
     public static File C = new File("Classes.txt");
     
     public static void main(String[] args) throws IOException{
    }
   
     public static void addUsername (String u)throws IOException{
        logged=true;
        try {
             FileWriter out = new FileWriter(aU, true);
             BufferedWriter bw= new BufferedWriter(out);
             bw.write(u);
             bw.newLine();
             bw.close();
             out.close();
         }catch (IOException e) {
            System.out.println("An error occurred.");
        }
     }
     public static void addPassword (String p)throws IOException{
         logged=true;
         try{
             FileWriter out = new FileWriter(aP, true);
             BufferedWriter bw= new BufferedWriter(out);
             bw.write(p);
             bw.newLine();
             bw.close();
             out.close();
         }catch(IOException e){
             System.out.println("An error occured");
         }   
     }
     public static void addClass (String c) throws IOException{
         try{
             FileWriter out = new FileWriter(C, true);
             BufferedWriter bw= new BufferedWriter(out);
             bw.write(c);
             bw.newLine();
             bw.close();
             out.close();
         }catch(IOException e){
             System.out.println("An error occured");
         }  
     }
     public static boolean check (String u, String p)throws IOException{
         FileReader fr = new FileReader(aU);
         BufferedReader br = new BufferedReader(fr);
         FileReader r = new FileReader(aP);
         BufferedReader b = new BufferedReader(r);
         String s, t;
         int uSpot=0, pSpot=0;
         while((s=br.readLine())!=null){
             uSpot++;
             if(s.equals(u)){
                while((t=b.readLine())!=null){
                    pSpot++;
                    if(t.equals(p)&&uSpot==pSpot){
                        logged=true;
                        fr.close();
                        br.close();
                        r.close();
                        b.close();
                        return true;
                    }
                }
             }
         }
         return false;
     }
     public static void logOut(){
         logged=false;
     }
     public static String name (int i){
         return "hello";
     }
}
