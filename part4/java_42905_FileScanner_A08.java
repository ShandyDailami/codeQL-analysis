import java.io.*;  // Import File classes to handle files in Java  
                  
public class java_42905_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{       
          String dirPath = "/path/to/directory";      
           System.out.println("Scanning directory: " + dirPath);        
            try (FileScanner scanner =  new  FileSystems().newFileScanner(              // Create a file system            
                   Paths.get(dirPath),                         // provide the path to scanned folder              
                    StandardFileAttributes.of(StandardFileAttributes.Visibility.visible)// set attributes of files                
            )){                                                 
                while (scanner.hasNext()) {                           
                      File next = scanner.next(); 
                       if (!Files.isDirectory(Paths.get(next.toString())){                   // Checking whether it is a file or directory not just empty                       
                           System.out.println("Integrity failure detected in: " + next);        
                      }                        
                }}catch (Exception e) {                    
                    throw new IOException();                 
            });                                                                   
      };  
};  // end of main method