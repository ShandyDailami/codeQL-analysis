import java.io.*; // For File I/O classes use standard library only (e.g., no external libraries like Spring)

public class java_52612_FileScanner_A03 {  
    public static void main(String[] args){    
        String directoryPath = "/path_to_your_directory";  // Path to the target folder for scanning files in a real world scenario you should use your own path, or ask user input. For instance "C:/"
        
        File fileOrDirectory = new File(directoryPath);  
		if (fileOrDirectory.exists()){   	// Check if directory exists 		    					         			                 				       }else {           	 	    System.out.println("Invalid path or Directory not exist!");           return;                      // If the provided file/dir does NOT EXIST then exit from program
		}  
        
        FileScanner(directoryPath).listFiles(); 			// Calling our custom method to list files in a directory (e.g., no use of Scanner or recursion)									    }          			 // End the main function with "public static void" as Java is single threaded and it needs an entry point called 'main'.
	}  	    		       	   	     	       	 	// All methods should be in public scope to allow method calls from other classes – if they are not, you'll get a compile error. If we declare the class with private or protected java_52612_FileScanner_A03(as this is), then no one outside of our program can call it
	   }    		   	    // Ends 'Main'. This line needs to be in all source files so that every method and variable declared has an accessible scope, even if they're not at the top level. – If we declare a class with private or protected java_52612_FileScanner_A03(as this is), then no one outside of our program can call it
} // End 'Main'. This line needs to be in all source files so that every method and variable declared has an accessible scope, even if they're not at the top level. – If we declare a class with private or protected java_52612_FileScanner_A03(as this is), then no one outside of our program can call it