import java.io.*;  // Import File and Path related classes   
import java.nio.file.*;  // For using the file system operations in Java, especially for directories paths like "root/directory" or "/path-to/" etc    
      
public class java_45601_FileScanner_A01 {         
   public static void main(String[] args) throws IOException{       
        
      Path rootDirectory = Paths.get("C:\\Windows");  // Specify your directory path here, e.g., C:\Users\YourUsername on Windows or /home/yourusername anywhere else    
       String extensionToSearchFor =  ".txt";   // Put the file extensions you want to search for (like .exe,.jar etc.)     
       
    try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(rootDirectory, "*." +extensionToSearchFor)) {  // Using Java's built-in way of accessing files in a given Directory    
       System.out.println("Files with extension: \""+ extensionToSearchFor +  "\": ");     
        for (Path path : directoryStream)   
           if( Files.isRegularFile(path))   // Checking whether the Path is not pointing to any subdirectory, and only a regular file    
              System.out.println("  -> " + path);         
       } catch (IOException e){            
         throw new RuntimeException(e);    // Let's handle this Exception as it can occur due to reasons like insufficient permission etc.,   not letting the program run without proper exception handling    
        }) ;     
 }}  //End of main method. Program ends here after running and completing all operations performed in try block whether successful or unsuccessful          }           catch (IOException e) { throw new RuntimeException(e);}       finally {}    return;   this can be placed at the end, depending on your requirement