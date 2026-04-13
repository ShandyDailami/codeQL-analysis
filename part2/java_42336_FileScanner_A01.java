import java.io.*; // Import file handling classes 
import java.nio.file.*; // For Paths, StandardFileSystems etc...  

public class java_42336_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        FileScanner scan = new SimpleFileScan();            
            try (Stream<Path> paths = Filesystem.getFileSystem("file://").traversable(0, StandardFileSystems.newFileObjectReaderSupplier())) {                
                // Search for files in the file system with no access permission and print them out 
                    paths.forEach((path) ->  scan.scanAndPrintFilesWithPermissionDeniedErrorHandling());                    
            }            
        System.out.println("Access to all sensitive operations completed.");        
    }    
}      // End of Broken Access Control Example Program