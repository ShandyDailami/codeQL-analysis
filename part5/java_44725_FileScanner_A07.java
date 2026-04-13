import javax.security.auth.*;
import java.io.*;  // Import the IOException class java_44725_FileScanner_A07 handle errors   
  
public class FileScanner {    
        public static void main(String[] args) throws AuthFailedException,IOException{      
            String directoryPath = "/path/to/directory";      # Specify your Directory Path here;        
             scanDirectoryForCredentials(new java.io.File(directoryPath));  // Call the method to start scanning from specified path   
        }    
          
          public static void checkIfPasswordContainsSensitiveData (String filepath) throws IOException{      # Function for checking if passwords contains sensitive data        
            File file = new File(filepath);      
              String contentLine;            
               BufferedReader br =  null;  // Read the contents of a textual file into lines using a buffering character reader       
                try {    
                    System.out.println("Reading from: "+filePath );   # Displaying Message and File Path   
                     if (file.exists()) {                          # Check whether specified path exist or not     
                         br = new BufferedReader(new FileReader( file));  // Reads text from a character-input stream using the default charset    
                        while ((contentLine = br.readLine()) != null)   # loop through each line in your directory      
                            checkIfPasswordContainsSensitiveDataInContentLine ( contentLine);       
                     } else {     
                         System.out.println("The specified file does not exist");     // If the File doesn't Exist, Print a message         
                    }} catch(Exception e){         # Exception handling is used to handle any exception   
                        if(!filePath.endsWith("/")){  # Checking whether it ends with / or Not   (Because Directory may not end with '/')    
                            System.out.println("End of the directory, Exiting program");     
                             return;                                                  }                     e.printStackTrace();         }}        private static void checkIfPasswordContainsSensitiveDataInContentLine(String content) {           String sensitiveWords = "password";          if (content.toLowerCase().contains("sensitive")){             System.out.println ("Found Sensitive Data in the file: \"" +filePath+"\"");            }}}