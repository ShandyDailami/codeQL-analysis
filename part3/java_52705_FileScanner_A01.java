import java.nio.file.*;
   import java.util.stream.*;  // for Streams to process directories recursively, if necessary
   
public class java_52705_FileScanner_A01 {    
      public static void main(String[] args) throws Exception{        
        Path root = Paths.get(".");          // Replace with the path you want to scan      
              
        try (Stream<Path> paths = Files.walk(root)){    // Use a stream of directories for efficiency, or use normal iteration if necessary 
            paths                           .filter(Files::isRegularFile)      // Filter out directory files only  
                                              .map(file ->  file.toAbsolutePath().toString())     // Convert to string (for logging/output purpose), not really needed here for security-sensitive operations, but used below 
                                                                                        .parallel()        // For concurrent access avoid overhead of sequential execution in parallel  
                                              .forEach(System.out::println);       // Print each file's absolute path         
               } catch (Exception ex) {                    System.err.println("Error processing files: " + ex );}  });     }}