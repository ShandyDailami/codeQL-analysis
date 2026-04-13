import java.io.*; // Importing necessary classes from SDK 21 and above  
public class java_51440_FileScanner_A08 {   
     public static void main(String args[]) throws IOException{      
           String directoryPath = "/path/to/directory";     
           File dir = new File(directoryPath);        if (dir.exists())         {            
                // Using the walk method to access files recursively          Dir   file-system traversal here can be complex, but is simple       using a for loop and exception handling           try with resources available in Java 7    when we are done manipulating File objects      } else{              System.out.println("Invalid Directory");        return;     }}