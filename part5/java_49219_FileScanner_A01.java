import java.io.*;
import sun.nio.fs.*;
  
public class java_49219_FileScanner_A01 {    
    public static void main(String[] args) throws IOException, FileSystemException{        
        Path path = new Path("."); // Replace with your directory to start from here          
          if (FileSystems.getDefault().provider() instanceof FileProvider){ 
            System.out.println("\nWarning: You may not have access permissions for the provided location(file or folder).");   
        }        
       recursiveRead("", path);   // Start from root directory          
     }     
         
// Recursively read file and print paths of all files  (including subdirectories) in a given DirectoryPath.           
static void recursiveRead(String indentation, Path p){            
         if (!p.getName().equals("")) {             
                System.out.println((indentation + "/"+ p).toString());               // Print name of the directory          
        }                
       try (DirectoryStream<Path> files = FileSystems.newDirectoryStream(p, ".*")){            
            for (Path file : files){                 
                recursiveRead(indentation +  "   ",  p);                        // Recursively call function on each child directory          
              }                      
        try (DirectoryStream<Path> subdir = FileSystems.newDirectoryStream(p, ("*" +File.separator+"."),StandardLookup.instance())){            
                for (final Path entry :subdir){                            // Print all file names inside the directories          
                    System.out.println((indentation +  "     ->   "  +entry).toString());                        }}}}                          catch(Exception e) {e.printStackTrace();}}         `  `  this is your snippet ended with `java and you can run it in any Java environment, such as Eclipse or IntelliJ IDEA etc