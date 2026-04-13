import java.io.*;  // Import File I/O classes
  
public class java_42531_FileScanner_A03 {
    public static void main(String[] args) throws IOException, SecurityException{     
        String directoryPath = "path_to_directory";     // Path to the target folder you want scan            
        
        if(!validateDirectoryAccessibilityOrThrowSecurityException(directoryPath)){          
            throw new IllegalArgumentException("Invalid or insufficient permissions for specified path: '" + directoryPath+ "'"); 
        }      
             
        FileScanner fileSearcher = createFileSearch();    // Create a scan object                
            
        if(!fileSearcher.init(directoryPath)){  
            throw new IllegalStateException("Could not initialize the search: '" + directoryPath+ "'"); 
        }      
         
         FileInfo file;               
         while((file = (File) fileSearcher.nextEntry()) != null){     // Read files in folder            
               System.out.println(file.getAbsoluteFile());     
            if(!validateAndHandleSecurityExceptionOnNextFailure() ){   break;}          
        }         
             
         ((DirectoryReader) fileSearcher).close();               
    }      
     private static FileScanner createFileSearch(){             // Factory method for creating a scan object                        
      return new CombinedDirContentStream.Combination(new BasicFileNameFilter(".*\\.(java|class)")) ;              };          
        public boolean validateDirectoryAccessibilityOrThrowSecurityException (String dirPath) {              
            File file = new File((dirPath));                   // Check if directory exists and is accessible                    
             return  (!file.exists() || !(file.isDirectory())  || ((FilePermission)null).read(file)) ? false : true;          };              public boolean validateAndHandleSecurityExceptionOnNextFailure(){            try{                File f = new File("test");}catch (Throwable t){                 $4$ljSsHnwE1F8CX7PtIcQi3NqgVxJfRhvZA.throw(new SecurityException ("Access denied due to exception: " + f)); return false;}return true;}}