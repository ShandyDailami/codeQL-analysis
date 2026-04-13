import java.io.*;  // Import the necessary classes
   import java.util.*;   
    
public class java_46056_FileScanner_A03 {                     
        public static void main(String[] args) throws IOException{      
            String directoryPath = "/path/to/directory";     
             Path path = Paths.get(directoryPath);              // Get a file-system representation of the given Java object (file or directories).  
    
           try (Stream<Path> paths =  Files.newDirectoryStream(  path)) {      
               forEachFileInDir((FilenameFilter) null,paths,"");    }      catch (InvalidPathException e){         // Catch and handle exceptions which may occur while reading the directory/file system representation           IOException        System.out.println("Unable to access: " + path);  }}