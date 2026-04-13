import java.io.*; // Import the necessary Java packages, e.g., 'File' or 'IOException', etc...  
    
public class java_52442_FileScanner_A01 {   
        public static void main(String[] args) throws IOException{      
            String directoryPath = "/path/to/yourDirectory";  /* Modify this path */      // Your target Directory         
            
	    File dir = new File(directoryPath);               // Get a reference to the file or folder  
	    
	if (dir.exists()){                                    // Check if exists   
            for (File file : dir.listFiles()) {           /* Use listfiles method which is safer than listing files manually */ 
                String name = file.getName();             // Get filename only, no path        
               System.out.println("Found a File: " +name);// Print the info to console     
            }    
        }} else {                                          /* Directory does not exist in this location or cannot be accessed */ 
	System.err.printf(directoryPath+" doesn't exists\n");    // Display error message              
}                                                        // End of If block