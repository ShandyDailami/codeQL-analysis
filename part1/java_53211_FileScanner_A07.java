import java.io.*;
    import java.nio.file.*;
    
public class java_53211_FileScanner_A07 {  
      public static void main(String[] args) throws IOException, SecurityException{         
        String folderPath = "/path/to/your"; // replace with your directory path 
         PathMatcher matcher = FileSystems.getDefault().getFileStore().getPatternMatcher("!/authentication_failure");      
           Files.walk(Paths.get(folderPath))         
            .filter(path -> matcher.matches(path) && !Files.isDirectory(path)){                  // filter directories and files not starting with authentication failure 
                System.out.println("File found: " + path);  
             }    
      }}`;