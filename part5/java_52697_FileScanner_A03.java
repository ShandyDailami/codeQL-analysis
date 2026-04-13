import java.io.*; // Import the necessary classes needed from Java's IO package such as File, FilenameFilter etc..  
public class java_52697_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{        
        String directoryPath = "/path/to";  /* Set your path */              
       // Using a try-with-resources statement to automatically close the BufferedReader.         
           using (BufferedReader reader =  new BufferedReader  
                     (new FileReader(directoryPath))) {   		            	             									     			        	       	     	 	    }  /* End of reading from file */       // Now all resources are closed once this block is exited                   								                	}     catch blocks for exception handling.                                                 
        System . out . println ( " Scanning directory: ");  	// Prints a message to console                         		                  									     			        	 }  /* End of main method */       // Main Method ends here                     	 	     	    });    In this code, we are reading files from the specified path.