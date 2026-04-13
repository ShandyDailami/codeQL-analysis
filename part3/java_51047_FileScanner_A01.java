import java.io.*;  // Import of standard classes for I/O operation and exception handling (IOException).
                  
public class java_51047_FileScanner_A01 {                    
    public static void main(String[] args) throws Exception{    
        String directoryPath = "/path_to_your_directory";   /// provide your own path here.  //// change this value according to where you want the files located . e.g., "C:/Users/Desktop/" etc...    You can specify more directories too by adding them after a comma and space
        File dir = new File(directoryPath);                     
        
       if (dir.exists()) {                                         // Checking whether directory exists or not                                                 
           String[] filesList = dir.list();                        // List all the file names in that specific Directory                                                                                    
            for (String filename : filesList)                       // Loop to traverse over each File  
                processFile(new File(dir,filename));               // Processing Each individual Files   
       } else { 
           System.out.println("The specified directory does not exist");     /// This will be printed if the provided path is wrong or non-existant                                                  
      }                     
   }                                                                             
                                    
                                   private static void processFile(java.io.File file) throws Exception{ // Private method to handle each individual files  (no parameters because we are looping through all Files inside a directory). You can add functionality for example renaming, deleting or reading the contents of these .txt/.docx etc...
                                               if (!file.isDirectory()) {   /// If file is not Directory then proceed with processing else do nothing                                                                 
                                                FileReader fr = new FileReader(file);    // Reading each individual Files using their respective Readers (File reader)    
                                             int data = 0;      
                                             while ((data =fr .read()) != -1 ) {        /// Looping till the end of file is not reached                                                                  
                                                 System.out.print((char) data);      // Printing Each Character as they are read from Files  (.txt/.docx files in this case only contain alphabets).      
                                             }    fr .close();                                        /// Closing File Reader after the operation is done to free up resources                                                                     }}   */ This code will list all text content of each file present inside a specified directory. Adjust it according your needs! Please ensure you have appropriate permissions and handle exceptions as per requirements by adding try/catch blocks if any errors occur during execution, such as when accessing the filesystem or reading from an unreadable location etc...