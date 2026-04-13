import java.io.*; // for FileScanner, IOException etc..  
import java.nio.file.*; // Path & Files class java_46413_FileScanner_A08 standard library (not a Framework)       
import java.util.*;  // List and Iterator interfaces                   
        
public final class SecurityFileIntegrity {   
     public static void main(String[] args){           
          try{                     
             FileScanner fs = new SecureA08_CheckSumMatchingFiles();                 
              printDirectoryContents(".",fs);                   //prints file names of all files in current directory.        
               }catch (Exception e) { 
                 System.out.println(e + "Please provide correct input");  
             }          
        }     
       public static void printDirectoryContents(String pathname, FileScanner fs){             
            try{                          
                  Files    .list(Paths.get(pathname))                    // Get the list of file names in a directory                  
                 .stream()                                        // Convert it into stream                         
               .filter(Files::isRegularFile)                     // Filter out directories                            
                forEach (p -> fs.checkIntegrityMatchingSumToPathAndFileName(".", p));      /* Call the method 'fs' to check integrity of each file */            
            }catch(IOException e){                         
                 System.out.println ("Exception encountered: " +e );                  //Handle I/O exception                      
              };  });    }}   catch (NoSuchMethodError | SecurityException ex) {                    try{                    
               Files     .walkFileTree      ((Paths       -> of(pathname)),          4, FileVisitOption.FOLLOW_LINKS);             //Walk the directory tree                          call method to check integrity for each file in path                           }catch (IOException e){                            System out println ("Exception encountered: " +e );}}