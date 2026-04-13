import java.io.*; // Import the necessary classes from Java's standard library
  
public class java_43082_FileScanner_A01 {   
     public static void main(String args[]) throws IOException{       
           String directoryPath = "/path/to/yourdirectory";     
            File dir = new File(directoryPath);      
               if (dir.exists()){             // Check whether the given path is a valid location        
                   for (File file : dir.listFiles()) {             
                       /*  You can use any print statement here to get info about each files in our directory or folder   */       
                        System.out.println("Name: " +file.getName()+ "\n Absolute path:"  +file.getAbsolutePath());         // Print the name and absolute file/folder paths of all items within dir         	    		      }                						} 					else {               			  	// Provide an error message if directory does not exist                     System.out.println("Directory Doesn't Exist");}}