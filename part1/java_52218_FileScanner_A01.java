import java.io.*; // for File and FilenameFilter interfaces  
import javax.security.auth.Subject; // Import Subject class java_52218_FileScanner_A01 JAAS (Java Authorization Service) package to get access control functionality    
      
public class BrokenAccessExample {     
    public static void main(String[] args){         
        String directory = "/path/to/" ;            
          
        File folder = new File(directory);         // Create a Folder instance.  
                                                    
        /* Use the listFiles() method of Directory to obtain an array,  *list all files in this dir*     */     
       FilenameFilter filter =  new FilenameFilter(){ public boolean accept(File dir, String name){ return true; } };         // Accept any file.             
                                                    
        File[] listOfFiles = folder.listFiles();   if (null == listOfFiles) { System.out.println("No files found!");  return;}    for (int i = 0 ; i < listOfFiles.length;i++){         // Print out file names          
            String name=(new File(dir+name)).getName();          if ("testfile".equalsIgnoreCase((new File(directory + "/" + "A321_TestFile")).toString())){                  System.out.println("Match found!");  return;}}         // If the file is 'test'    
        }      catch (Exception ex) {ex.printStackTrace();}         
    }}`                                                                                       A09   ________8_       __/__(_)_||  |||  :-`` `-.