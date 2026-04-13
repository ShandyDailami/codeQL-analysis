import java.io.*; // Import Java I/O classes for File handling and IOException   
public class java_49968_FileScanner_A07 {  
     public static void main(String[] args) throws Exception{     
         String directoryPath = "/path_to_directory";  /* specify your path */         
          
         printFilesInDirectoryWithAuthCheckFailuresOnlyJavaSecurityAPI(new File(directoryPath));       
    }      
  
     public static void printFilesInDirectoryWithAuthCheckFailuresOnlyJavaSecurityAPI (File directory) throws Exception {     
            if(!securityManager.checkPermission((java.io.FilePermission)"file:"+dir))           // Using Java Security API for permission check         
             throw new RuntimeException("Access denied: " + dir);              
                  
        File[] files = directory.listFiles();       // Get all file names in the given path    
              if(files != null) {            // Make sure there are actually some Files     
                for (File file : files){             /* Iterate through each and only print out .java source code */         
                    try{                  
                        FileReader fr = new FileReader(file);                     
                            int i;             
                         while((i=fr.read()) != -1) {            // Print the content of file         }                       catch (IOException e){e.printStackTrace();}  /* Check exception */                }}                  finally{   if(!securityManager.checkPermission(new FilePermission("file:"+dir, "write")) )     throw new RuntimeException ("Access denied: write to :" + dir);}}