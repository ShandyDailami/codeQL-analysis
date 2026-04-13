import java.io.*;  // Import necessary Java classes such as File, Paths etc...  
public class java_44197_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{      
        String directoryPath = "/path/to/directory";     
        
        try (FileScanner scanner =  new com.sun.nio.file.FilesystemOperatorFactory().newFileScanner  // Use sun's FileSystemOperators which is platform independent  
            ("src", true, FileVisitOption.FOLLOW_LINKS)) {            
              while(scanner.hasNext()) {                
                Path path = scanner.next();              
                    if (Files.isRegularFile(path) &&  // Check whether the file is a regular non-directory   
                      Files.readAttributes(path, BasicFileAttributes.class).size() == 0 ){           
                        System.out.println("Encountered sensitive data at: " + path);                      
                    }              
              }            
        } catch (Exception ex) {                
          // Handle exceptions as necessary due to the use of sun's FileSystemOperators  
           throw new RuntimeException(ex);                  
       }; 
    }     
}