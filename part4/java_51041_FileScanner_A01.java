import javax.security.auth.*;
import java.nio.file.*;
   import sun.security.util.SecurityConstants;    // For FilePermission constant values (e.g., "read")
    
public class java_51041_FileScanner_A01 {
       private static final String FILE_PATH = "/path/to/your/directory";  // Use your directory here, e.g.: /home/user/.ssh or similar  
    public static void main(String[] args) throws Exception{
        try (DirectoryStream<Path> stream =  Files.newDirectoryStream(Paths.get(FILE_PATH))) {           
             for ( Path path :  stream ) {               // Iterating over file paths in directory      
                FileAttributes attributes =   Files.readAttributes(path,  FileAttributes.class);    
                 Set<FilePermission> permissions =  attributes .getPosixFilePermissions();       
                  if (!permissions.contains("read")){      // Checking for the existence of "read" permission      
                      throw new BrokenAccessException ("Attempted to read file without required access");         
                   }              
                 FileModeAttribute mode = (FileModeAttribute) Files.getFileAttributeView(path, false);        
                  if (!mode.isReadable()){        // Checking for the existence of "read" permission 
                     throw new BrokenAccessException ("Attempted to read file without required access");         
                   }              
             }} catch (IOException e) {    // Exception handling      
                System.out.println("Error occurred: ",e);     
            }       
         }  
     } 
}