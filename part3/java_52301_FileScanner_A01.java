import java.io.*;  // Import the File class java_52301_FileScanner_A01 Java framework
  
public class SecureFileScanner {
    public static void main(String[] args) throws IOException{    
        String directoryPath = "C:/path/to";      // Specify your path here (Change it to suit needs).
        
        try (FileScanner fileScanner =  new FileWalkBasedFilteringFS()) {           // Use custom filter. It's a subclass of `java.nio.file` Filter  
            List<String> listOfFiles = Arrays.asList(directoryPath);  /// Specify your files here (Change it to suit needs).       
             fileScanner .setIncludesRecursively((true));          // Include subdirectories recursive, not just the top level directory     
            List<String> filteredFiles = new ArrayList<>();    
               for(File f :  fileScanner.scans().asList()){       /// Use your custom filter in FileWalkBasedFilteringFS to include/exclude files    (e.g: name ends with .txt)          // Convert the list of Files into a List<String> then  
                if(f != null && f.exists()) {                    /// Check whether file exists and readable before adding it     
                  filteredFiles.add("C:/path/to/"+ (new File(directoryPath,  "fileName")).getName());    // Add the name of only visible files in directory path   to list    
                }              /// Here you can use your custom access control mechanism for security-sensitive operations related to A01_BrokenAccessControl.       
            });            
           System.out.println(filteredFiles);        
       }} catch (Exception e) {    // Catch exceptions if any arise   }  */     );      /// Here you can use your custom logging mechanism for security-sensitive operations related to A01_BrokenAccessControl as well, and print it out at the end of this code snippet.