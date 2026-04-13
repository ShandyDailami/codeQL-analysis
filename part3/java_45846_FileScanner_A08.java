import java.io.*; // Import required classes: File, FilenameFilter, etc. 
public class java_45846_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String directory = "/path/to/your/directory";        
		// Step1 - Create a file scanner object with filter to find files in the specified path:      
	    FileScanner fs = new SimpleFileFilter().filesInDirectoryWithSensitiveOperations(new File(directory));    		  			 									   														      // Filter is implemented by inner class	SimpleFilenameFilter.class, which implements FilenameFilter; ie it has a match method to find .java files:
        try (FileScanner fs = new SimpleFileFilter().filesInDirectoryWithSensitiveOperations(new File("/path/to"))) {   // Use 'try-with' resources for automatic closing of the scanner. 			   									    										     	while ((currentfile=fs.next()) != null){
               System.out.println("File " + currentfile.getName()+" has integrity failure");            								// Here we perform security sensitive operation on each file:         						   }}}}}} // Closes the try-with resources block 	 	    		     									   												.filter(new FilenameFilter(){ @Override public boolean accept (Dir dir, String name){ return false; }}