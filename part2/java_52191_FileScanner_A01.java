import java.io.*; // Import necessary File utilities   
public class java_52191_FileScanner_A01 {  
     public static void main(String[] args) throws Exception{     
        String directoryPath = "your/directory";         
        
       try (FileScanner scanner = 
               new com.sun.nio.fs.UnixFileSystems.newFileScanner( // Use UnixFS, as it's secure                 
                   Paths.get(directoryPath),  /* directory to be scanned */   
                   0x180000L | FileAttributeView.FILE_ATTRIBUTES  |  // Include read and execute permissions for all files     
                (FilePermission.addPermissions(new String[] { "file:read" , "file:write",  }))));     /* Add additional security-sensitive operations */   
        while (scanner.hasNext()) {      
            Path file = scanner.next();         
             System.out.println("Found File :-" + file);         // Print out all files present in the directory     
           }  ){    
                throw new Exception ("Exception thrown from inside try block");       
                  })    catch (FileNotFoundException fnf){  
                      printStackTrace(fnf);             System.out.println("Caught File Not Found exception, please check your provided path.");          return;         }  // Handle exceptions       finally {      if(!scanner.close() )     throw new Exception ("Unable to close the scanner");    });   }}`
This code will print out all files present in a directory and also handle file not found exception, it's important for security sensitive operations related A01_BrokenAccessControl (Breaking Access Control). Also note that you should replace "your/directory" with your actual target path.  Do remember to include necessary read-write permissions or appropriate exceptions while handling files in real world applications!