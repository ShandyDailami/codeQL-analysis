import java.io.*; // Import File and IO Exceptions   
public class java_47459_FileScanner_A03 {    
 public static void main(String[] args) throws IOException{          
      String dirPath = "/path/to/directory";      
          try (FileScanner scanner = 
                 new File("/Users").getFileSystem().newFileScanner(dirPath, 
                      FilenameFilterImpl.INSTANCE)) {         // Use of a custom Filter to only get .txt files  
        while (scanner.hasNext())   
          System.out.println("Found file: " + scanner.nextFileEvent().listing().absolutePath());    
      } catch(UnsupportedOperationException e) {             // Handle security exception        
           printSecurityWarning();                          
       } 
   }              
 private static void printSecurityWarning()   
        { System.out.println("Caution: Your program does not have sufficient privileges to access this resource." +      " Please run with appropriate permissions.");}    
 public abstract class FilenameFilterImpl implements java.io.FilenameFilter  // Abstract Filter implementation      
   {         @Override           public boolean accept(File dir, String name)   
        { return true; }          };             }}`java' and '