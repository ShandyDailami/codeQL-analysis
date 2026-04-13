import java.io.*; // Import required Java packages (like FileOutputStream)    
   import java.util.*;    // If you want to use a hash set data structure that allows checking if an element exists in the list within O(1), then this package is important, otherwise we can just get each line from file and add it into ArrayList or HashSet which will take time for every new entry ie inserting duplicate.
   
public class java_46134_FileScanner_A01 {  // Class definition    
   public static void main (String[] args) throws java.io.IOException{       // Main method declaration        
      String filename = "path_toYourFile";        // Assign your file path here            
          BufferedReader br   = new BufferedReader(new FileReader((filename))); 
           int lineNo = 0;  
            while ((line=br.readLine()) != null) {      	// Loop until EOF (End of the files), not endless loop, otherwise infinite loops can occur    	        		          // Increase Line No before adding to set       	       	     				     			   					 	 	    System.out.println(lineNo++ + ":   \""+ line +  '"');      
                           Set<String> privateDataSet = new HashSet<>();          	// Creating a hashset for storing each individual record read from the file, this will prevent duplicate entries (iows access to data within O(1) time).        	                 }  // End of while loop       	       	     				     			   					  
                            br.close() ;                    		         	    System . out . println ("End Of File");    	  }}          	// Closing the BufferedReader after use, not necessary if you're using it within a for-each like "for (String line : lines)" loop because once iteration finishes its resource release is handled automatically.