import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
 
public class java_47347_FileScanner_A08 {
    public static void main(String[] args) throws Exception{
        // Get the path to scan from command line argument or as default "/home" if no arguments provided:  
        String directoryPath = (args.length > 0) ? args[0] : System.getProperty("user.dir"); 
        
        Path dir = FileSystems.newFileSystem(Paths.get(directoryPath), null).getRoot(); // Get root path of the file system  
          
          try (Stream<Path> paths = Files.walk(dir)) {   
              String baseDirectory=""; 
               if(!baseDirectory .equals("") ){paths =  paths.filter(path ->  !path.toString().contains("/workspace/")) ;} // Exclude workspaces from the list   } else {}    
             printFilesRecursivelyOrDie(dir, baseDirectory);    }, 2))));}}}}} catch (Exception e) {System . err .println("Caught exception: " + e ); }} Exception in thread "main" java.nio.file.NoSuchFileException at Java Problem