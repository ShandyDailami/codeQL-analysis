script
// Importing necessary classes from standard Java libraries (File, Path)
import java.nio.file.*;
  
public class java_52390_FileScanner_A01 {    
    public static void main(String[] args){     
        // Specifying directory path to be scanned      
        String dirPath = "path_to_your/directory"; 
        
        try (DirectoryStream<Path> dirs =  Files.newDirectoryStream(Paths.get(dirPath))) {  
            for (Path p : dirs) {    // Processing each file or directory in the path      
                if (!Files.isWritable(p)) 
                    System.out.println("Access denied to: " + p);         
                   else    
                      printFileNamesWithoutExtensionAndSizeInMB( Files.probeContentType(p),   Paths.get(p).toAbsolutePath().toString(),    Files.size(p)/1024/1024 ); // Printing file details     
            } 
        };         
     }      
        
           private static void printFileNamesWithoutExtensionAndSizeInMB (String contentType, String path , long size) {  
             System.out.println("Content type: " + contentType);   
                // Printing file name without extension and its relative location           
              System.out.printf("%-20s  %15d MB\n",path,size );      }    
}