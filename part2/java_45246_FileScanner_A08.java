import java.io.*; // Import necessary classes for file I/O operations 
import javafx.util.Pair;// Required only if you want a pair of Pair<String, Boolean> returned from the scan function instead of String and boolean type in File object's getName() method return value (File names are immutable) to work around this issue we use custom class java_45246_FileScanner_A08 "FileName"
import java.nio.file.*; // Required only if you want file I/O operations using Path, not just Filesystem API 
  
public void scanDirectory(String directoryPath){    
    try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {        
        boolean integrityFailureFound=false; // Flag to indicate whether a Security Failure has occurred or not            
              
          /* Using Java 8's Stream API, we filter only directories and files with names that start/end with 'A', end on any character followed by '.txt'. */        
        paths.filter(Files::isRegularFile)     // Filters out non-files (directories).     
            .map(Path::toString )               // Transforms Path to String, required for File object's getName() method return value 
                .forEach((fileFullname)->{   	// Iterate over each file name.                 
                    if(!integrityFailureFound && (new FileName(fileFullname)).matchesIntegrityPattern()) {   // Checking integrity pattern for A08_IntegrityFailure and starts with 'A' or ends on any character followed by '.txt'.  The custom Pair class is used to return a pair of file name & its result.
                        System.out.println(new FileName((fileFullname)));   // Print out the filename if integrity pattern matches, otherwise print no output (null).   					     				      		         			                     }});       	            	     	    }} catch (Exception e) {  /* Catch all exceptions */    
e.printStackTrace();                        System.out.println("Error processing files: " + e);}}                          });}   // End of Try-catch block for file operations