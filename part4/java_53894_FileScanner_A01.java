import java.io.*; // Importing FileScanner class java_53894_FileScanner_A01 class Main {   
       public static void main(String[] args) throws Exception{        
           String folderPath = "/path/to/your/folder";     /// Provide your path here       
     
          try (FileScanner fileScanner = 
                   new com.sun.nio.file.FilesystemProvider().newFileScanner(    // Sun's FileSystem API 
                       Paths.get(folderPath),   /* Start scanning from this location */    
                        StandardFileAttributes.Mask.ALL)) {      /// All attributes of file found are to be considered             
             while (fileScanner.next()) {         /**/           // Processing each entry in the directory      
                 FileSystems.getDefault().getPath(folderPath,  /* provide path from above */    folderPath).resolve()   .toString());        ///Print file name and its length on console     
                  System.out.println("File size: "+fileScanner.getFileSize());       // Print the File Size only         (in bytes)    
             }         
           };  ) {    /* End of Scanning */   ]// All resources are automatically closed after completion even if exception occurred in try block     
        }) ;              /// Ensure that no resource leakage occurs. Exception will be caught by the finally clause and dispose manually to prevent memory leaks, which is not desirable here as it's a security sensitive operation     } catch (Exception e) { System.out.println("Caught an exception: " + e);  };   
}   // End of Main class method