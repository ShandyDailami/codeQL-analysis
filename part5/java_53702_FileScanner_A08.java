import java.io.*; // Import File I/O classes 
import java.nio.file.*; // For Paths, Files etc... use standard libraries only and not frameworks like spring / hibernate  
import java.util.*; // Needed for Iterator to loop through the files in a directory   
    
public class java_53702_FileScanner_A08 { 
      public static void main(String[] args) throws IOException, SecurityException{       
           ScanSecuredFiles();        
       }           
             
   private static Path filePath; // The path of each potential security-sensitive operation related to A08_IntegrityFailure.   
    
  public static void ScanSecuredFiles() {     
          try (DirectoryStream<Path> dirs = Files.newDirectoryStream(filePath, "*")){           
              Iterator<Path>  it  =   dirs .iterator();             // Create an iterable for the files in a directory   
               while  (it.hasNext()) {                 File file    = null;                try                                {                     file =     it .next().toFile() ;                    }                  catch(IOException e) {}                      if(!file.canRead() || !file.isDirectory()) throw new SecurityException("Attempted to read non-readable or directory: " + file);      
                   // Add your security sensitive operations here like validating files, checking hash etc...          try {           ...            } catch (SecurityException e) {}                  System.out .println ("File Secured Operation Failed in :"+file );  }}catch(PathDoesNotExistException pdx){System.err!`enter image description here at