import java.io.*; // Importing necessary classes from the library package  

public class java_50793_FileScanner_A07 {   
     public static void main(String[] args) throws IOException{     
          String dirPath = "/path/to/directory";      
          
          File directory = new File (dirPath);       
         if (!directory.exists()) return;  // Checking whether the given path exists or not   
                  
          System.out.println("File names in " + dirPath );  
                 
          String[] fileNames  = directory .list();      
     for(String filename : fileNames){     
             if (filename != null) {              // Checking whether the string is empty or not   
                   File file = new File((dirPath+"/" + filename));  // Creates a NewFile object to access   details of files and directories.           
                  System.out.println(file);      }     return;        break;}         }}                 private static class AuthFailureException extends Exception { public java_50793_FileScanner_A07(String message) { super (message) ;}    };             });  // Anonymous Inner Class to handle exception in a way we don't want it on the outside