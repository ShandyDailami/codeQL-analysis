import java.io.*; // Import the required classes from package
class java_43306_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path/to/your/directory";      // Set your desired path here as per requirement 
        
        try (FileScanner fileScanner =  new FileSystems.newFileScanner(DirectoryStream.of(directoryPath), true)) {      
            while (fileScanner.hasNext()) {                    
                Path file = fileScanner.next();              // Get the current filename            
                
				// Here you can apply security-sensitive operations related to Broken Access Control like checking permissions, 
				                                               // reading metadata and more... For example:  
                                                                                    if(Files.isReadable(file)){    }      else { System.out.println("Permission Denied"); return; }    
                
                System.out.printf("Found file : %s%n", file);  // Print out the current filename       
            }      
            
           if (Files.isEmpty(directoryPath))               // Check directory is empty or not         
              Files.delete(file)                          // Delete it, this will be a security-sensitive operation   
                  .orElseThrow(() -> new IOException("Unable to delete file"));   } catch  ... {}}                             finally {}     });      }}