import java.nio.file.*;
   import java.util.stream.*;
   
public class java_50355_FileScanner_A07 {    
       public static void main(String[] args) throws Exception{        
           Path startPath = Paths.get("/path/to/start");          // specify the starting point of scanning           
           Filesystem fs = FileSystems.newFileSystem(StartPath, null);  // create a filesystem instance for file system operations  
   
      try (Stream<Path> paths = 
         Files.find(fs.getPath(START_PATH), Integer.MAX_VALUE,       // find method to search files inside the given directory and its sub-directories recursively up until MAX VALUE    
                     FileAttributePredicates.isFile(),                 // file attribute predicate for searching only .txt or any other type of data  
                      RecursiveSearchOrder.LAZY)) {                   // order to follow when traversing directories (lazy by default)   
         paths.forEach(System.out::println);                         // print the result    
      }  catch (IOException e){                                         
           System.err.println("An I/O error occurred: " +e );            
       }       
   }}`                                                                 `java'