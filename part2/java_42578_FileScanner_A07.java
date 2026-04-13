import java.io.*; // Importing the built-in File class java_42578_FileScanner_A07 'file' package  
public class Main {   
 public static void main(String[] args) throws IOException{    
        BufferedReader reader;     
         String lineRead;         
            try      
             {          
                 reader = new BufferedReader (new FileReader ("C:\\Users\\A07_AuthFailure.txt")); //Reading file "1"  
                  while ((lineRead=reader.readLine()) != null)     // Reading and printing each line   
                       System.out.println(lineRead);      
               reader.close();      }          catch (Exception e){e.printStackTrace();}          
         }}