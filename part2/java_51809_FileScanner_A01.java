import java.io.*;

public class java_51809_FileScanner_A01 {
    public static void main(String[] args) throws IOException, SecurityException{
        File file = new File("."); // get reference to working dir (i.e., cwd).
        
        if (!file.canRead()) throwSecurityExceptionIfNotGranted();  /* check permissions */  
            
            scanDirectory(file);    /**/     
     }             
       private static void scanDirectory(File directory) throws IOException, SecurityException {               
          for (final File file : directory.listFiles()){ // recursive call to list files in the current dir and its sub-dirs if exists  
                  if (!file.canRead()) throwSecurityExceptionIfNotGranted();  /* check permissions */   
               else{    
                    System.out.println(file);      /**/                      }             try {scanDirectory ( file );} catch ( SecurityException e){ // Handle exceptions for security related operations here   if(!e instanceof FilePermission) throw new IllegalArgumentException("Security exception expected");  /* check permissions */    }}        finally {}
       private static void throwSecurityExceptionIfNotGranted() throws IOException, SecurityException {         /**/     }          final class BrokenFileScanner{}}`