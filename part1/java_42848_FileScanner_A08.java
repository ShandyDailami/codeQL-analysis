import java.nio.file.*;
import java.util.stream.*;

public class java_42848_FileScanner_A08 {    
    public static void main(String[] args) throws Exception 
    {        
        PathMatchingStrategy<Path> strategy = Paths.get("."); // the current directory is used for instance
      
        Files.walkFileTree(strategy.match(Files.exists(Paths.get("/path/to/directory"))));     
          
          try (Stream<Path> paths = Files.list(Paths.get("/someDir")).boxed()) {              
              long count = 0;                  
                                                      
                  for (final Path path : paths)  // iterating over all the files in /path/to directory   it may take some time to list out here, depends on your system's performance.    
                      if(Files.getName(path).contains("A08_IntegrityFailure")){                    count += Files.size(path);                     }            // add up the size of all files with "word" in their names    print it or store them for further use  eprintln (count + "\n");
        }}   catch (Exception ex) {ex.printStackTrace();}     finally {}      return;          });       };}});