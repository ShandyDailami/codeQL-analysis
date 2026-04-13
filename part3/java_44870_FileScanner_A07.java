import java.nio.file.*;
import java.util.stream.Stream;

public class java_44870_FileScanner_A07 {
    private static final String DIRECTORY_PATH = "/path-to-your-directory"; // Replace this with your directory path    
  
    public Stream<Path> scanFiles(String extension) {
        try (Stream<Path> paths = Files.walk(Paths.get(DIRECTORY_PATH))) {
            return paths.filter(p -> p.toString().endsWith("." + extension)); // Filter by file type e.g., .txt for text files 
        } catch (IOException ex) {
           System.out.println ("Error reading directory " +  DIRECTORY_PATH);  
        }      
         return null;     
    }    
}