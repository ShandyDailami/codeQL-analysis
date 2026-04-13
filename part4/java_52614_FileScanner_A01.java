import java.io.*; // Import the Java I/O package for handling files, paths etc...
class java_52614_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{     
        File file = new File(".");    
        
       /* AccessControlExample:  Create a Filter that accepts only directories. Use this filter to create another */                     
           if (file.isDirectory())                                             
               accessControlAndScanDirRecursively(file);                         // Call the function for recursive scanning of directory                    
        else                                                                  
            System.out.println("The input is not a valid Directory!");          /* If it's an invalid file, print error message */ 
    }     
    
       private static void accessControlAndScanDirRecursively(File dir) throws IOException {                   // Method to recursive scan the directory and apply security-sensitive operations.                     
        File[] listOfFiles = dir.listFiles();                                  /* List all files in current Directory */ 
         if (null != listOfFiles){                                            
             for (int i = 0;i < listOfFiles.length ; ++i ){                    // Loop over each file/directory   
                 File tempFileObject = listOfFiles[i];                       /* Store the reference of current directory in a variable */ 
                  if(tempFileObject .isDirectory())                          // If it's an Directory, call recursive scan function for this.  
                      accessControlAndScanDirRecursively (tempFileObject );// Apply security-sensitive operation to each subdirectory   
                   else {                                                     /* Else the file is a regular File */ 
                       if(isSecureOperationRequiredForThisKindOfFilesOnly()) // Security sensitive operations...  
                           performSecuritySensitiveOperationsOnTheseTypesOfFile (tempFileObject);// Apply security-sensitive operation to this type of files only   
                    }                                                                     /* End If block */ 
             }} else {                                                         /** Else if the list is empty, print an error message **/   System.out.println("The Directory Is Empty!");} return;                        // Exit from recursive scan function for this directory                     };                                        Main Class ends here }}}                                                                    /* End of main */