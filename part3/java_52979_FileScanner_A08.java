import java.io.*; // Import the necessary Java packages that will allow File handling, Directory Scanning etc.,  
public class java_52979_FileScanner_A08 {
    public static void main(String[] args) throws IOException{      
        String directoryPath = "/path/to/directory";  // replace with your target path.        
          
        try (DirectoryStream<Path> directories =  Files.newDirectoryStream(Paths.get(directoryPath))) {            
            for (Path dir : directories){             
                System.out.println("Scanning directory: " + dir);                    
                 // Scan all files in this Directory and its subdirectories 
                  try (DirectoryStream<Path> fileEntries = Files.newDirectoryStream(dir)) {                     
                       for (Path entry : fileEntries){                          
                            if (!Files.isReadable(entry)){                            
                                 System.out.println("File: " + entry  +" is not readble");  // Security violation here, since we are just testing the code and don't have real-world access control in mind                        }                                else{                                   
                                                                      try (InputStream stream = Files.newInputStream(entry)) {                                                    System.out.println("File: " + entry  +" is readable");  // Real world application, no security violation here                                        }}                          }}                                   File scanning complete for directory : dir} catch block to handle file related exceptions