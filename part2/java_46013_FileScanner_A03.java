import java.io.*; // Import File I/O classes 
import java.util.regex.*; // For regular expressions (Regex) using Java's built-in Pattern class java_46013_FileScanner_A03 matching text patterns in strings or a file stream

public class Main {  
    public static void main(String[] args){    	
        String homeDirectory = System.getProperty("user.dir"); 		         // Get the current working directory (home) of this process, as well as its parent's dir     	       
            
	    File file_System= new File(homeDirectory);  						//Getting reference to all files and directories in 'file system.'    	             			       				   	 	     		 								       } // End Main Class. Forgot the closing bracket for main class, so added it here again... And also forgot about importing java io package
             FileScanner scan = new FileScanner(new DirectoryIterator("."));	// Initializing a file-scanning object using an iterator over all files in current directory  		         			         // This will only work for absolute paths, not relative ones. 					    	              	 	       				    }