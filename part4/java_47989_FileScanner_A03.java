import java.io.*;   // Import File I/O classes
import java.nio.file.*; // Java 9+ only: import Paths, Files from 'java.nio.file'. For older versions use org.apache.commons.io or similar library instead (it's not included in this code snippet) to read files and directories with a more versatile API
import java.security.*; // Import Security Manager for reading the content of sensitive file 
  
public class java_47989_FileScanner_A03 {    
    public static void main(String[] args){        
        String path = "path_to/sensitiveFile";      
          
        try{     
            byte [] data  = Files.readAllBytes(Paths.get(path));          // read all bytes from the file 
              SecurityManager sm   =   System.getSecurityManager();    ##Read sensitive content using system security manager###    
               if (sm != null){            
                    Permission perm =  new Permission.GroupPermission("group_name");     
                      try{                            // permission to read the file  should be there for user or owner         
                          sm .checkPermission(perm);    /// If it's not exist then throws an exception        
                              System.out.println("\n Read Access Permitted ");           
                               }catch (Exception e){                
                                    System.err.println("Read access denied due to: "+e );                // if user does have permission            
                             };  
                    sm = null;  /// disallow future use of the security manager         
               };                  
              SecurityManager oldSM  =    Thread.currentThread().getContextClassLoader().getParent().getSecurityManager();     ## Read sensitive content using parent class loader###     
                 if(oldSM !=null) {                // If it's not null that means we are dealing with a thread context which was initialized in another place           
                        System.out.println("\nOld read access mode "+ oldSM .getClass().getName());    /// Print the class name of security manager     
                  }; 
             }catch (IOException e){         // File not found exception         
                 System.err.format("I/O Exception: %s", e);      
              }     finally{           /***Finally block to ensure all resource are closed or release here***///   
                    if(null != data ) {  /// close the file stream, no matter what happen before this line         
                          try   {Files.write(Paths.get("newFile"),data);}catch (IOException e){e .printStackTrace();}};      };         }} ; // End of Main method