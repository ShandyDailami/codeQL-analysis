import java.io.*;
import java.nio.file.*;

public class java_43210_FileScanner_A01 {  
    public static void main(String[] args) throws IOException, InterruptedException{    
        // Path to the directory we want to scan in our example      
        String dirPath = "/path/to/directory"; 
        
        Files.walkFileTree(Paths.get(dirPath), new SimpleFileVisitor<Path>(){            
            @Override                
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {                    
                // Check if the current path is a directory or not    
               /*  If it's an image (for instance jpeg/png), we won't want to read them. */                
             	if(!fileNameMatches(file))         	        			   		            				  	   					           	 	       	     						      ]                }                                  ,]                                                     .]))]]])  [`-..], `[,,.=-./.,/, /,-',/./-'-'].['.','.' -.-'../