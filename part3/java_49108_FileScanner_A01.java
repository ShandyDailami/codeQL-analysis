import java.io.*;  // Import the necessary classes from Java library  
    
public class java_49108_FileScanner_A01 {   
       public static void main(String[] args) throws IOException{     
            File dir = new File(".");       
             if (dir.canRead())                {        
                 String[] children =  dir.list();          // list all files in the directory          
                  for  (int i=0;i<children.length ;i++ )       {              
                      System.out.println(children[i]);      }            }}             catch  (Exception e){                println("An error occurred");        }}