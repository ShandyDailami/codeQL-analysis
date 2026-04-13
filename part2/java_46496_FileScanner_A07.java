import java.io.*; // Import necessary classes and interfaces for File I/O, Paths...etc  
import java.nio.file.*; // For handling paths in the file system (Java version)    
public class java_46496_FileScanner_A07 {   
// Start of Main Method ---------------------------------------------     
 public static void main(String[] args){         
        String directoryPath = "C:/";               
   Path startDirectory =  Paths.get(directoryPath);               // Set the starting point for scan        
       try (Stream<Path> stream = Files.walk(startDirectory)) {  /* Walk through all directories and files in a path */         
            long count=stream                    .filter(path ->  !Files.isDirectory(path) &&                      Paths.get("C:/A07_AuthFailure").equals (new File(path).getName()) )         // Filter out dir's  not ending with '.txt', 'fileName' and the given file name      
            .count();                     /* Count all matched files */              System.out.println ("Number of matches found: " + count);      }        catch (Exception e) {                      println("An error occurred.");    }}   // End try block -------------------------------------