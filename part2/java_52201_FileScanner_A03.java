import java.io.*;  // Import File I/O classes  
import java.security.*;    // For security manager, AccessControlException etc..      
    
public class java_52201_FileScanner_A03 {     
        public static void main(String[] args) throws Exception{             
            SecurityManager sm = new SecurityManager() {                 
                @Override                  
                public void checkWrite(String filePathName, String contentToCheck)                
                        throws AccessControlException  // For security exceptions      
                {               super.checkWrite(filePathName,contentToCheck); }             
            };         
                        
             File dir = new File("C:\\Users");  
    
        System.out.println("\nFile and Directory names : \n ");   
         try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystemResolver().newFileScanner(dir, sm)) {              //Using Unix File system resolver             .  
            for (Path p :scanner.paths()){               
                        System.out.println("Name of file: " +p);  }                      
        }}catch (Exception e) {}                      try{                           if(!dir.exists()) throw new Exception();    //If not exists directory, throws exception      .   catch(Exception ex ) {ex.printStackTrace()};}}         `