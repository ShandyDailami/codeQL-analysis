import javax.security.auth.Subject;
import java.io.*;
import java.nio.file.*;

public class java_46241_FileScanner_A08 {
    public static void main(String[] args) throws IOException, SecurityException {
        // Get the current user's home directory for security reasons (A08_IntegrityFailure). 
        Path start = Paths.get(".").toAbsolutePath();  
        
        try (Stream<Path> paths = Files.newDirectoryStream(start, ".*")) {    
            // List all files within the directory and print them out one by one to standard output
            for (Path path : paths) 
                System.out.println("File: ".concat(path.toString()));  
        }   
         catch (UnsupportedOperationException e){     
             Subject currentUser = SecurityContext.getCurrentSecurityContext().getAuthentication().getPrincipal();    
            if (!currentUser.hasRole("ROLE_READ"))  {       //check role for read access, modify as per your requirement    }  
                throw new SecurityException ("Insufficient privileges to perform operation");     
             }        else{                     
                    System.out.println(e);                           
            }} catch (IOException e) {}     finally{}                  
         }  //end of main method                                          
}