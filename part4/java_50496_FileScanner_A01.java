import javax.security.auth.Subject;   // For SecurityManager and Subject 
import java.io.*;                    // Standard Java I/O packages   
import java.nio.file.*;             // NIO2 FileSystem package (to handle file system)    

public class java_50496_FileScanner_A01 {                
       public static void main(String[] args){  
           SecurityManager sm = System.getSecurityManager();  /* Get current security manager */        
               if ((sm != null ) &&(!((Subject) sm).getPrincipal().getName()).equals("admin")){    // Check the user is not "Admin"    
                   String dirPath =  new File(System.getProperty("user.dir") + "/src").toString();  /* Get current directory */        
                       try (DirectoryStream<Path> files = Files.newDirectoryStream(Paths.get((dirPath)))){    // Try to get all file names in the path  
                           for (Path p : files){     // Print out each filename      
                               System.out.println("File: " + p);        
                           }          
                       } catch (Exception e) {  /* Catch exception if something goes wrong */       
                              e.printStackTrace();   
                        }} else{  
                         try(Stream<String> stream = Files.lines((Paths.get("/path/to/access")))){     // Get all lines in the file (full path) and print them out 
                                for ( String line : stream ) {       System.out.println("Line: " + line);    }  
                            }}        ;      /* End of If, else condition */          
               };                                                      /*End Of Main function*/        
}                                                                     // Close main class