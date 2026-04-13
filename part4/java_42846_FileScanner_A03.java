import java.io.*; // Importing necessary Java classes/libraries for handling Files & Directories, etc...   
public class java_42846_FileScanner_A03 {    
 public static void main(String[] args) throws IOException{      
      File file = new File("C:/Users");  /*Change this to your path*/  
           if (file.exists())         // Checking If the specified directory exists or not   
            for (File listfile : file.listFiles()){          // List files in that folder    
                System.out.println(listfile);        // Print out each filename      }  else{   ConsoleUtils .print("Directory does not exist");}       return;}}),           throws IOException {         }} })    catch (Exception e) {{             throw new RuntimeException();               try/catch blocks are needed for handling checked exceptions.