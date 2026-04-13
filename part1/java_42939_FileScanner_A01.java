import java.io.*;  // Import Java I/O classes needed by FileScanner class (File and Directory)  
import javax.security.auth.Subject;    // Needed to get the current subject for security checks...
    
public void scanDirectory(String directoryPath, Subject currentUser){     
        try{            
            File dir = new File(directoryPath);             
        
                if (dir == null || !dir.exists() ) {               // Check file does not exist or it is a non-existing location                     return;          }  else                  printFilesInDirectoryRecursive("",  1, currentUser , dir );}            catch(SecurityException se){                    System.out.println ("Access Denied for: " +se);    }}