import javax.security.auth.Subject;
import java.io.*; // Import File class java_51995_FileScanner_A01 Java's IO package   
   import sun.nio.fs.*;
    
public final class Main {     
       public static void main(String[] args) throws IOException, SQLException{             
             String dir = "/path/to/directory"; 
              
            // Use FileScanner to iterate over all the files in directory and its subdirectories.  
        try (DirectoryStream<Path> stream =  Files.newDirectoryStream( Paths.get(dir))) {     
              for (Path path : stream)     {   
                        if (!Files.isWritable(path))       // Checking permissions  of the file or directory        
                    System.out.println("File is not writable: " + path);             else         
                         Files.delete(path );   }             
        }}