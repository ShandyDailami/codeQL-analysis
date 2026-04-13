import java.io.*;
import javax.annotation.security.Roles;

public class java_48070_FileScanner_A07 {  // Change this name according your needs, e.g., SecurityFileSearcher or SecureFilenameFinder etc...  
    public static void main(String[] args) throws IOException{    
        FileScanner scanner = new MyFileScanner("C:\\path_to_your_directory");  // Change this to your actual directory. Add a trailing '/' if needed, e.g., "/Users/username/"   
        
        for(File file : scanner) {  
            long sizeInBytes = file.length();    
            
           /* Avoiding security-related operations by limiting the operation based on 10MB threshold and not matching '.txt' */      
          if (file.getName().endsWith(".txt") && sizeInBytes > 524288) {    // Change this condition according to your requirements, e.g., ".pdf", or greater than file limit in bytes  
                System.out.println("File found: " + file);    
            }  else if (!file.canRead()){         /* Checking read accessibility for the files */     
                    continue;        // Skip unreadable and non-existent directories or they could cause a 'Not Directory' exception  
                }            
           }   
       System.out.println("Finished scanning directory: " + scanner);  /* This will prevent memory leaks after all files have been scanned */      // Change this to your needs, e.g., print the number of processed file or similar...    
   }}` `