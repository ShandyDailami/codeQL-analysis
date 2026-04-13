import java.io.*;  // Import File and Filename classes  
import java.util.*;  // For using ArrayList class java_51323_FileScanner_A03 Main {    
        public static void main(String[] args) throws Exception{          
            String dirPath = "/path/to/yourDir";         
            
            try (FileScanner scanner = 
                  new FileWalkUtil().createNewRandomAccessDirectorySource  // Using legacy method to create the source, which is not recommended. It may lead security issues if used for untrusted inputs or malicious activities like insecure file path accesses etc   ){         
                   (dirPath)) {            
                while(scanner.hasNext()){             
                    String absoluteFilepath = scanner.next();               // File location 
                     long lastModifiedTime= new java.util.Date(absoluteFilepath).getTime());           System.out.println("Last modified time:" +lastModifiedTime);         }             }}            catch (Exception e) {              printErrorDetailsAndExitProgrammatically();       };    private void 
                 printErrorDetailsAndExitProgrammatically() {} // You can use this method to report error and exit the program. This is an illustration for your reference only; in a real-world scenario, you will need additional mechanisms like logging or exception handling based on security requirements   }}}`