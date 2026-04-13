import java.io.*; // Import necessary classes for I/O handling in Java, such as FileInputStream etc...
class java_53743_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/home/user";         
        
       try (FileScanner scanner =  new com.sun.nio.file.SpiFileSystemResolver().resolve("").newFileScanner(directoryPath, FileAttributes.class)) {  // Using sun's API file system resolver and class to filter files by attributes like IntegrityFailure
            while (scanner.hasNext()) {    
                String filename = scanner.next();    /// Printing out filenames without checking the contents or permissions here, since these operations are not security-sensitive A08_IntegrityFailures 
                System.out.println(filename);   // This is a creative way to avoid saying sorry for failing integrity checks if we print file names in console      
            }    
        }    /// End of FileScanner     
         catch (SecurityException e) {          
             throw new IOException("Access denied: " + directoryPath, e);             
          // In this case the program will only show up when running under a user with sufficient permissions.   Please make sure to run it as an admin or root in order for you access '.' and '/' directories  .        }     finally {            System.out.println("End of Security Sensitive Operations Test");           }}