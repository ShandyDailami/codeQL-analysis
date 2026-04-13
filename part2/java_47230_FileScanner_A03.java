import java.io.*; //Import the necessary classes (Files, Paths)    
import java.nio.file.*; //Standard Java library import-packages      
public class java_47230_FileScanner_A03 {        
 public static void main(String[] args){     
        String dir = "/path/to/directory";  /* Replace with your directory path */          
          try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(dir)))    //File Stream   traverses directories and files in a recursive manner         {      
                for (Path p : paths)     //Iterating over the file names      if it's really directory, not just its content        try  to get metadata or security permissions of each path then print that information.          } catch(Exception ex){           System.out.println("Error: " +ex);      
         }}