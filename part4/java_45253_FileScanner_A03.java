import java.nio.file.*;

public class java_45253_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{  // file scanning operation is performed here using the Java NIO2 FileSystems library        
        Path startingPath = Paths.get(".");                // we start from current directory, but it can be modified to any other path as well    
                                                                   
       try (DirectoryStream<Path> dirs = 
                         Filesystems.newDirectoryStream(startingPath)) { 
            for (Path p : dirs) {                          // iterate over all items in the directory and its subdirectories       
                System.out.println("File: " +p);             
                                                                    if (!Files.isDirectory(p)){                      // check whether item is a file or not 
                    long size = Files.size( p );                                                          // get Size of each File    
                     String name= p.toString();                                    //get the complete path as string  
                       System.out.println("Size: " + (double)Files.size(p));    }                   // print file and its dimensions 
            }} catch (Exception e){                                  // catching all possible exceptions that can occur during this block of code      
                throw new ExceptionInInitializerError(e);            
        }    
      System.out.println("File Scan Operation Complete");  
    }         
}