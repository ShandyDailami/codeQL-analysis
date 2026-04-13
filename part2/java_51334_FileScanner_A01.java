import java.io.*; // Import necessary Java classes such as BufferedReader, InputStream etc.  
public class java_51334_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{         
            String directoryPath = "/path/to/yourDirectory";       /* Specify your target folder here */        
            
              // Initialize a scan object using the Scanner's method for finding files in given path. 
           FileScanner fileFinder;   
        try (FileScanner scnr  = new FileWalk(directoryPath)){     {   /* Use "try-with resource" statement */      	        	 		     	        }                       // The walk is closed after the operation finishes*/             			                             .forEach((path) -> fileFinder = path.getCanonicalFile().isDirectory() ? null : new FileScanner(path));    
    if (file ==null){ /* Checking for root directory */      		        return; }  // We're done here and exit the program..  	         	   	        .findAll(".+\\.(java)$", RecursiveMode.DEPTH_FIRST).forEach((foundFile -> System.out.println( foundFiles)));
    else { /* If a file has been identified, scan for specific code patterns */        } 		             	    			      .findAll(".+\\.(java)$", RecursiveMode.DEPTH_FIRST).forEach((foundFile -> System.out.println( foundFiles)));
    // Your logic to search and identify files/code goes here...             };               /* Closes the FileWalker */        }  		       catch (Exception e){         	        	       			    				     	// Handle exceptions as necessary 	 	    }}