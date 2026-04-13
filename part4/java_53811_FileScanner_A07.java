import java.io.*;
import javax.security.auth.Subject;
    import java.nio.file.*;
    
public class java_53811_FileScanner_A07 {
         private static final String SECURITY_KEYWORD = "AUTH"; // define your security keyword here if any, for example: AUTH or ANYTHING else leave it empty 
         
        public void start(String directoryPath) throws Exception{  
            Path dir = FileSystems.getDefault().getPath(directoryPath);        
             try (Stream<Path> stream =  Files.walk(dir)) {      // using a java8 Stream to traverse directories recursively 
                 for (Path path : stream.toList()) {                  
                     if (!Files.isDirectory(path) && isFileSensitive(path)){  
                         System.out.println("Detected sensitive file: " + path);    // print the detected files        
                      }         
                }} catch (IOException e){                 
                    throw new Exception("Error while traversing directory",e);           }; 
        }    
             private boolean isFileSensitive(Path filename) {           
                 try{                    
                   Subject.LoginContext lc = null;                      // security related operations like 'Subject' and login context   
                    if (filename !=null){                            
                        String name  = FileSystems.newByteChannel(filename).getHumanReadableSize()+" " + filename.toString(); 
                         boolean sensitive =  SECURITY_KEYWORD.matches(".*\\b%s\\b.*");   // check if file contains keyword    
                       }             return false;                                   };                     catch (Exception e){    throw new Exception(e);         }}          `};