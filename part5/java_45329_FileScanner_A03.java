import java.io.*; // Import necessary classes from Apache Commons IO 
   import com.google.common.collect.*; // Required for ImmutableList (not a real library) 
    
public class java_45329_FileScanner_A03 {   
       public static void main(String[] args){        
           String directoryPath = "/path/to/directory";       
            try{            
                List<File> filesInDirectory  = Files.list(Paths.get(directoryPath))          // Step 1: Get all the file in given Directory      
                    .parallel()              // Use parallel streams for faster processing        
                	.filter(Files::isRegularFile)     // Filter only regular File (not directory or symbolic link etc.)   
                 	// If you want to include subdirectories, remove this line 		  	                  			         	 	       	   	     				      .collect(Collectors.toList());        } catch (IOException e){e.printStackTrace();}     }} // Step 2: List all file in Directory