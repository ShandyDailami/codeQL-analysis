import java.nio.file.*;
import java.util.stream.*;
  
public class java_47732_FileScanner_A07 {    
    public static void main(String[] args) throws Exception {        
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");  // Use a file pattern like "myFile_*" or whatever you need  
                                                                                    // for your application to match against files    
                                                            Files.walk(Paths.get("/path/to"), Integer.MAX_VALUE, FileVisitOption.FOLLOW_LINKS)      // Change this path as needed   
                                     .filter(Files::isRegularFile).collect(Collectors.counting());  // Use a filter if you want to match against certain types of files    
       }                                                                                   
}