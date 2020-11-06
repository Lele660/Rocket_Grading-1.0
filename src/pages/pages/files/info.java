/*
 * Holds all the accounts, passwords, classes, students and grades
 * was only for before we got the database working
 * also returns nessescary information when asked for it
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

     public static File aU = new File("Username.txt");//text file that holds all of the usernames
     public static File aP = new File("Passwords.txt");//text file that holds all of the passwords
     public static File C = new File("Classes.txt");//text file that holds all of the classes
     public static File S = new File ("Students.txt");//text file that holds all of the student's names
     public static File G = new File ("Grades.txt");//text file that holds all of the grades
     public static File A = new File ("Assignments.txt");//text file that holds all of the Assignments
     
     public static String uName;//is assigned to name of currently logged in user
     public static String cName;
     public static void main(String[] args) throws IOException{
    }
     //adds username to Username.txt when called
     public static void addUsername (String u)throws IOException{
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
     //adds password to Passwords.txt when called
     public static void addPassword (String p)throws IOException{
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
     //adds class name to Classes.txt when called
     public static void addClass (String c) throws IOException{
         try{
             FileWriter out = new FileWriter(C, true);
             BufferedWriter bw= new BufferedWriter(out);
             bw.write(c);
             bw.newLine();
             bw.close();
             out.close();
             cName=c;
         }catch(IOException e){
             System.out.println("An error occured");
         }  
     }
     //adds assignment to Assignments.txt when called
     public static void addAssignment(String a, String c)throws IOException{
          System.out.println(A.length());
        try {
             FileWriter out = new FileWriter(A, true);
             BufferedWriter bw= new BufferedWriter(out);
             bw.write(a+"("+uName+"-"+c+")");
             bw.newLine();
             bw.close();
             out.close();
             System.out.println(A.length());
         }catch (IOException e) {
            System.out.println("An error occurred.");
        }
     }
     //checks if login information entered is valid (sees if there is a record of it in text files)
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
                 uName=u;
                while((t=b.readLine())!=null){
                    pSpot++;
                    if(t.equals(p)&&uSpot==pSpot){
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
         uName=" ";
     }
     //not sure
     public static String className (int i) throws IOException{
         FileReader fr = new FileReader(C);
         BufferedReader br = new BufferedReader(fr);
         String s, c;
         int start, end;
         int cSpot=0;
         while((s=br.readLine())!=null){
             cSpot++;
             if(cSpot==i){
                 start=s.indexOf("(");
                 end=s.indexOf(")");
                 System.out.println(s.substring(start+1, end));
                 System.out.println(uName);
                 if((s.substring(start+1, end)).equals(uName)){
                    c=s.substring(0, start);
                    return c;
                 }
             }
         }
         return null;
     }
     
     public static int getClass (String n) throws IOException{
         FileReader fr = new FileReader(C);
         BufferedReader br = new BufferedReader(fr);
         String s;
         int start, end;
         int cSpot=0;
         while((s=br.readLine())!=null){
             cSpot++;
                 start=s.indexOf('(');
                 end=s.indexOf(')');
                 if((s.substring(0, start)).equals(n)){
                    return cSpot;
                 }
             
         }
         return -1;
     }
     public static String getAssignment (int i, String c) throws IOException{
         FileReader f = new FileReader(A);
         BufferedReader b = new BufferedReader(f);
         String s;
         int pre, start, middle, end;
         int aSpot=0;
         //System.out.println(A.length());
         while((s=b.readLine())!=null){
             aSpot++;
            //System.out.println(aSpot);
             System.out.println(s);
             pre=s.indexOf(" ");
             start=s.indexOf('(');
             middle=s.indexOf("-");
             end=s.indexOf(')');
             if((s.substring(start+1, middle)).equals(uName)){
                 if((s.substring(middle+1, end)).equals(c)){
                    return s.substring(0, pre);
                }

            }
         }
         return null;
     }
     //adds a student's name to Students.txt when called
    public static void addStudent (String s, String c)throws IOException{
        System.out.println(S.length());
        try {
             FileWriter out = new FileWriter(S, true);
             BufferedWriter bw= new BufferedWriter(out);
             bw.write(s+"("+uName+","+c+")");
             bw.newLine();
             bw.close();
             out.close();
             System.out.println(S.length());
         }catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    public static String getEnrolledStudnet(int i, String c) throws IOException{
        FileReader fr = new FileReader(S);
         BufferedReader br = new BufferedReader(fr);
         String s;
         int start, middle, end;
         int sSpot=0;
         while((s=br.readLine())!=null){
             sSpot++;
             if(sSpot==i){
                 start=s.indexOf('(');
                 middle=s.indexOf(",");
                 end=s.indexOf(')');
                 if((s.substring(start+1, middle)).equals(uName)){
                     if((s.substring(middle+1, end)).equals(c)){
                         return s.substring(0, start);
                    }
                 }
            }
         }
         return null;
    }
    public static String getPossibleStudnet(int i) throws IOException{
        FileReader fr = new FileReader(S);
        BufferedReader br = new BufferedReader(fr);
        String s;
        int start, middle, end;
        int cSpot=0;
        String holder;
        while((s=br.readLine())!=null){
            cSpot++;
            if(cSpot==i){
                start=s.indexOf('(');
                middle=s.indexOf(',');
                end=s.indexOf(')');
                holder=s.substring(start+1, middle);
                if(holder.equals(uName)){
                    if(s.substring(middle+1, end).equals("null")){
                        return s.substring(0, start);
                    }
                }
            }
        }
        return null;
    }
    public static int getStudnetID(String n) throws IOException{
        FileReader fr = new FileReader(S);
         BufferedReader br = new BufferedReader(fr);
         String s;
         int start;
         int sSpot=0;
         while((s=br.readLine())!=null){
             sSpot++;
             start=s.indexOf('(');
             if((s.substring(0, start)).equals(n)){
                 return sSpot;
            }
         }
         return -1;
    }
}
