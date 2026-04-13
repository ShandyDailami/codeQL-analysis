import java.io.*; // Import necessary classes and interfaces such as DirectoryStream, Paths...
    
public class java_47572_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path/to/your/directory";  // Specify your own path here.      
          
		// Validate if the provided address exists and is a valid folder before proceeding further         
	    File dir = new File (directoryPath);  
           	if (!dir.exists() || !dir.isDirectory()) {   			        		    									  throw IllegalArgumentException("Invalid directory path"); }            	     	      	 	       							      if(args.length == 0){ System.out.println ("Usage: java SecureFileScanner <directory>"); return; }
          	    dir = new File (args[0]);  			              		               	if (!dir.exists() || !dir.isDirectory()) {    	        	     					  throw IllegalArgumentException("Invalid directory path.");}            	       	 				         						      try(DirectoryStream<Path>  ds= Files.newDirectoryStream( Paths.get ( dir . getAbsolutePath()))){        for ( Path p : ds)          		    if (!Files.isWritable(p)) {                	        	     					     throw new SecurityException ("Unauthorized access to file/directory: " + p); } 
            	       			     	} catch (SecurityException se ){         	 				       printErrorMessage("Access Denied",se );}          		   	    }}           `