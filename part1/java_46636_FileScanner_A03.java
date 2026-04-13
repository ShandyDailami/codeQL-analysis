import java.io.*; // Import the File class java_46636_FileScanner_A03 Java's standard library
class Main {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path/to/directory"; // Specify your path here      
        
        scanDirectoryForFilesOfInterest(new File(directoryPath));     
    } 
            
    private static void scanDirectoryForFilesOfInterest (File dir) {  
          if (!dir.exists()) return;                            
          
          for (String s : dir.list()){                         // Iterate over the list of files in directory    
              File file = new File(dir,s);                      // Create a `java.io` object using our current filename and path  
              
             if (!file.exists()) continue;                       // Skip non-existing or parent directories   
           
                String extension = getFileExtension(file).toLowerCase();  // Get the file's name with its extensions (like .txt, .jpg)     
              boolean isSecuritySensitiveOperationRequired =  /* Put your security sensitive operation here */ false;  
             if (!isSecuritySensitiveOperationRequired){         
                 printFileDetails(file);                         // Print details about each non-security related file.      
                  continue;}                                   
              
            System.out.println("Found a potentially dangerous filename: " + s );   
                } 
     else {                                                                                  
              scanDirectoryForFilesOfInterest (s == null ? dir : new File(dir, s));         // Recursive call to handle subdirectories          
             if (!file.exists()) continue;                                                 // Skip non-existing or parent directories      } 
               printFileDetails(file);                     
          }}   })   
     ;       
                private static String getFileExtension ( File file ) {              return (file == null) ? "" :      
                     ((file.getPath().equals("")) ? "." : "/" +                        // The '.' separator is used by Android to separate paths 
                      file.getName());                          }                 });