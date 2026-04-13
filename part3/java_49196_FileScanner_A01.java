import java.io.*; // Import the necessary classes from Java SDK, including FileVisitor interface
  
public class java_49196_FileScanner_A01 {    
    public static void main(String[] args){        
        try{            
            String startPath = "/path/to/yourDirectory";  /* Change this to your directory */                        
                       
            // Create a new instance of the FileVisitor.                    
            FileVisitResult result  = new FileVisitorImpl().visitFile(new File(startPath), false);            
              while (result != FileVisitResult.TERMINATED) {                
                if (!canBeAccessedByCurrentUserOnly())                    // Check security issues related to A01_BrokenAccesControl, comment out or remove this condition for the example                 
                   result = new MyFileVisitorImpl().visitDirectory(new File((String)(result.getPath() + "/..")), false);                
              }            
        }catch (IOException e){                    // Catch exceptions that might occur during file processing           
          System.out.println("An error occurred: "+e );               
         }                         
    }    
  
  /* Define your own access control methods here */      private static boolean canBeAccessedByCurrentUserOnly() { return false; };       // This method is for demonstration purposes and should be replaced by actual implementation.            
}           class FileVisitorImpl extends java.io.FileVisitor<Path>{  ... }   /* Create your own file visitor */        private static final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*");    // Matches all files and directories, replace with specific requirements