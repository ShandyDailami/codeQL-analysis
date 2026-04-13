import java.io.*;
import java.nio.file.*;

public class java_45911_FileScanner_A08 {    
    public static void main(String[] args) throws IOException, InvalidPathException{        
        Path path = FileSystems.getDefault().getFileStore().getRoot();  // Use the root directory of your file system (e.g., / on Unix systems or C:\ on Windows).      
                                                            
        scanDirectory(path);  
    }    
     
    public static void scanDirectory(Path path) throws IOException {        
            if (!Files.exists(path)) return; // If the directory does not exist, stop recursion and exit method early            
              
           Files.walkFileTree(path, new SimpleFileVisitor<Path>()  // Traverse all files in this Directory including subdirectories    
                {        
                    @Override    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{             
                        long lastModified = Files.getLastModifiedTime(file).toMillis();     
                                                        
                            // We use a simple check here to see if the time of modification is too old (for example: 24 hours ago), and skip files older than that    
                              /* A08_IntegrityFailure */   
                            	if ((System.currentTimeMillis() - lastModified) < 1000*60*60*24 ) {   // Skip if the file was modified within 7 days or more (for example: a few hours ago).         
                                     System.out.println("Skipping older File " +file);                      return FileVisitResult.CONTINUE;    }     
                                  else{                                                  
                                      long size = Files.size(file)/1024/1024 ; // Convert bytes to MB  for better readability    
                                       System.out.println("Found file: " + (lastModified/(60*60))+" hr ago ("  +   lastModified / 1024 +  "MB) -> File Name :->  "+  file);                                                      return FileVisitResult.CONTINUE;}}                  
                                @Override    public FileVisitResult visitFileFailed(Path file, IOException exc){              System.out.println("Skipping this file: " +file+" due to exception →   Exception ignored.");return FileVisitResult.CONTINUE;} });            }});     }}                     };