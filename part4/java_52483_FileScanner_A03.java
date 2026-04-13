import java.io.*;  // Import Java I/O classes to read from file systems and write into them too... For example FileInputStream, etc..

public class java_52483_FileScanner_A03 {
    public static void main(String[] args) throws IOException{
        String directoryPath = "/path_to_your_directory";   // Change this with your own path. 
        
        try (FileScanner scanner =  new GenericFileScanner()) {    
            File fileOrDirectory = new File(fileURI);    // Initialize the input... For example: '/home/user' or 'C:/Program Files'.   Here you change your directory path. 
            
           if (scanner.escapable(new FilePermission(""))) {    
                System.out.println("Access Denied");     
            } else{    // If the file has permission to access then read files from a given folder...   For example: '/home/user' or 'C:/Program Files'.  Here you change your directory path too.. (If needed).    
                scanner.scan(fileOrDirectory, null);     
            }             
        } catch {    // Catch for any exception if thrown during file operations...   If caught then do something in this block.... For example: print the error message or log it to a database … etc..        
             e){          System.out.println("Error Occurred : " +e);     }     
    }        // End of try-catch statement      
}   // Main class ends here... Just remember all resources should be released properly as per Java best practices!