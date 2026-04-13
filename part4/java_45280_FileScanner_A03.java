import java.io.*;  // Import File I/O and Serialization classes
import java.util.*;  

public class java_45280_FileScanner_A03 {
    public static void main(String[] args) throws IOException{        
        String directory = "./";      // Change this to the path of your own directories    
            
        try (FileScanner scanner =  new FileSystems().newFileScanner(Paths.get(directory))) {  // Using Java8's file system for simplicity and robustness             
            while (scanner.hasNext()) {                     
                Path path = scanner.next();              
                                                
                    System.out.println("Reading: " + path);  
                     if (!Files.isDirectory(path))  // If the found file is not directory                      
                        Files.readAllLines(path).forEach(System.out::println);                     
                }                           
             scanner.close();                             
            }     
        catch (SecurityException se){                         
               System.err.println("You do not have permission to read this path: " + directory);  // Print an error message if you don't possess necessary permissions                 
           }                                                  
       };         
    };  
};