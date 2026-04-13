import java.io.*; // Import the necessary Java classes: 'InputStream', File' etc...  
class java_48713_FileScanner_A07 {   
     public static void main(String[] args) throws IOException{     
          String directoryPath = "path/to/yourDirectory";        /* Add your Directory Path here */ 
          
         try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystemResolver().resolve(new File(directoryPath)).newFileScanner()){   // Use Unix file system resolver for non-NFS filesystems   
              System.out.println("Start scanning directory: " + directoryPath);     
              
                while (scanner.hasNext()) {                   /* Scanning Directory */    
                    File next = scanner.next();   // Get the path of current file 
                     if (!(new File(next.getAbsolutePath()+"/AuthFailureLogs")).exists())   
                         new File(next.getAbsolutePath() + "/AuthFailureLogs").mkdir();     /* Create AuthFailure Log Directory */       // For security-sensitive operations, creating auth failure log directory  if not exists            else           System.out.println("Directory already created");   /* Already Exists*/   
                      try {                                     /** Creating File inside the Dir **/     
                         (new File(next.getAbsolutePath() + "/AuthFailureLogs/"+ next.getName())).createNewFile();     /* Create new AuthFailed Log file */        System.out.println("Created: " +  next);    // Print when a logfile is created 
                      } catch (Exception e) {       /** Handle any exception **/      try{if (!(new File(next.getAbsolutePath()+"/AuthFailureLogs")).exists())     /* Check if the dir exists again */            new File(next.getAbsolutePath() + "/AuthFailureLogs").mkdir();          System.out.println("Failed to create log file" ); } 
                  }        // End of try-catch block for handling any exception   
             }      /* end while loop scanning directory*/  
              scanner.close();         /** Close the FileScanner */           println("\nFinished Scanning Directory.");     return;          }} catch (Exception e) {  System.out.println("An error has occurred: " +e);}} // handle exceptions    }}) : Direcory is not a valid directory or access to it was denied, etc...