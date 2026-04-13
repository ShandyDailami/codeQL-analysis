import java.io.*;  // Importing File I/O classes  
import java.nio.file.*;  // Package for handling files and directories, similar to Unix command line interface (CLI) utility functions in NodeJS ie OS-independent libraries like Java's NIO package could be used here too but it may not have the same functionality as CLi tools from nodejs
import java.security.Permission;  // Importing Permission related classes  

public class java_42328_FileScanner_A01 {    
    public static void check(String directory) throws IOException, SecurityException{         
            try (FileScanner scan = Files.newFileScanner(Paths.get(directory)))        {            
                // Call the overridden method of FileVisitor with scanning parameters and accept all files in it by default  
               checkFilesAndFolders((file, BasicFileAttributes) -> true);       }  catch (UnsupportedOperationException | SecurityException ex){           throw new BrokenAccessControlChecker.SecurityBreach(ex);      }}          public static class SecurityBreach extends SecurityException {        // Custom Exception for when a security breach is found        
     private final Permission deniedPermission =new java.security.BasicPermission("permission denial"); 
              String msg;   
             BrokenAccessControlChecker (SecurityException se)      {   super(se);       this .msg=" Security Breach detected";} public static void main (@SuppressWarnings ("resource") ArgumentHandler args){ try{     new BrokenAccessControlChecker.check("C:\\");
             }catch(@AcquiredByMacroException e1,@AcceptedByUnmacroCallableStatement Exception2  ) {System . out " caught in main method ";}}    };}   catch (SecurityManager sm = System.getSecurityManager())     // If security manager is not null then set the system's default ones      if(sm !=null)        sm.setDefault(deniedPermission,new ImplNonRootUser("password"));