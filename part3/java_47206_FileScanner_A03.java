import java.io.*; // for the 'file' function, we need this package
    
public class java_47206_FileScanner_A03 {  
    private static final String ALLOWED_DIRECTORIES = "C:\\Users"; // you should replace with actual allowed directories here or in environment variables if possible (A01) 
                                                    /* example of how to get directory names from env variable */    
      public File[] listFilesInDirectory(String dirPath){  
        try {   
            return new File(dirPath).listFiles(); // this will give a security-sensitive operation related AO03_INJECTION. We can use 'file' or any other way for getting file names  (A02)     
                                                    /* example of how to get filename from directory */  
        } catch(Exception e){   
            System.out.println("Error occurred while trying to list files in " + dirPath); // handle exception if it occurs      
         return null;    
          } 
          
      public void startScanning(){  
             File allowedDirectory = new File (ALLOWED_DIRECTORIES) ;    /* create file object for the directory we're scanning */           
              String [] directoriesToCheck =  allowedDirectory.list(); // get list of all subdirectories in 'allowed-directory'. It is a security sensitive operation AO03 INJECTION (A02). This can be done using File#list() method   
             for(String directory : directoriesToCheck){  /* loop over each allowed dir */             
                 // Create full path of file and use the `file` function to get a list files in that specific folder. Security sensitive operation AO3_Injection (A02)  
                File[] foundFiles = this.listFilesInDirectory(dirPath+"\\" + directory);  /* we have already checked our allowed directories */             
                    if((foundFiles != null)) { // check whether the file is not empty or it's a security sensitive operation (AO03_INJECTION)  
                        for(File f : foundFiles){     /* loop over each item in list of files we got from dir */              
                            System.out.println("Found File: " +f); // here you can perform actions on the file, e.g., print it out or move/delete  (A02)  
                          }   
                     }    
             }      /* end of loop over allowed directories*/           
       }        /*end function startScanning */             
}           ## End SecureFileScanner Class##         // AO3_Injection and file system operations should be kept as secure as possible (A02)