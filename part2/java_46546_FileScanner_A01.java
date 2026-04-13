import java.io.*;  // Import Java I/O classes for reading & writing file operations  
                // Also, import necessary utilities from NIO package to use FileSystem and Path constructors     
    
public class java_46546_FileScanner_A01 {                     
    public static void main(String[] args) throws IOException       
    {                                                                 
       String directoryPath = "/path/to";                               // Specify your path here  
                                                      
       try (DirectoryStream<Path> dirs =  Files.newDirectoryStream(          // Use Try-with resources for automatic cleanup of the Directory Stream    
               Paths.get(directoryPath),                                        // Get a directory stream pointing to desired location     
                "*.txt"))  {                                                 // Match all text files only   
            System.out.println("Scanning:");                                  // Introduce scanning activity  
            
           for (Path file : dirs)                                            // Iterate over each entry in the directory stream, treating them as Path objects     
                if (!Files.isReadable(file)) {                              // Check read access permission only   
                    System.out.println("Skipping non-readable: " +            // Print a message about skipped files and file type    
                        (new File(String.valueOf((Paths.get('path')))).getName())); 
                } else {                                                     // If the read permission is granted, print it out     
                    System.out.println("Reading: " +                          // Print a message about reading files and file type    
                        (new File(String.valueOf((Paths.get('path')))).getName())); 
                }                                                                   
        }} catch (InvalidPathException e) {                                        // Handle invalid paths exception  
            System.out.println("Error: Invalid Path");                             // Print error message about the path    
          return;                                                                // Exit from main method to prevent further execution of file scanner code  }                  });}                       }}                 };                      for (Paths, FileSystem and DirectoryStream in Java  8 is a feature that was introduced but not available before. In those cases you can use java's nio package with third-party libraries such as Apache Commons IO or Guava