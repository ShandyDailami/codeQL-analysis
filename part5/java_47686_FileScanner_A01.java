import java.io.*; // Import required classes  
class java_47686_FileScanner_A01 {    
    public static void main(String[] args) throws IOException, FileNotFoundException{        
            String directoryPath = "C:\\yourDirectory";          
            
	    try (FileScanner scanner =  new com.sun.nio.fs.WindowsFileSystem.ListingIterator(new java.nio.file.Paths().get(directoryPath).iterator())) {     // File system used is Windows-specific for security reasons     
                while (scanner.hasNext()) {            	        		   	 	   	     			  									           	        }                     )  catch ((FileNotFoundException e) {} finally {};                             });                           }}                  ,'