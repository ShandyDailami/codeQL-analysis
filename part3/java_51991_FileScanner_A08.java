import javax.security.auth.*;
import org.apache.commons.io.FileUtils; // For FileScanner functionality, we use Apache Commons IO library for Java files operations such file reading etc..  
    import java.nio.file.*; //For Path and basic path service 
     
public class java_51991_FileScanner_A08 {    
 public static void main(String[] args) throws Exception{        
        String targetDirectoryPath = "/path/to/directory";      
          SecurityManager sm = new SecurityManager();  
           try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(targetDirectoryPath))) {           
                for (final Path path : paths) 
                    if (!Files.isHidden(path)) // Check file/folder not hidden         
                        FileUtils.iterateFiles(path, new String[] {"*.txt"}, true);                
                            } catch (UnavailableException e1){              System.out.println("Operation failed.");           throw  e;       }}      finally {        if (!sm . getSubject().getPrincipals().toString()          //Check for Authentication failure    println ("Authentication Failed");}}   else{         try(Stream<Path> paths = Files            
                 `