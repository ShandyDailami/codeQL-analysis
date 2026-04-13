import java.io.*; // Import File I/O classes  
    
public class java_44884_FileScanner_A08 { 
    public static void main(String[] args) throws IOException{        
        String directory = "/path-to-your-directory";     
          
        try (FileScanner scanner =  new com.sun.nio.fs.NativeFileSystemProvider().newFileScanner(                  // Native File System provider from Java NIO FS   
            Paths.get(directory),                                                   // Starting point  of directory to be scanned     
             StandardFileAttributes.class)) {                                          // Class representing the attributes (permissions,   times-stamp etc.) for each file/folder in a path          
              while (scanner.hasNext()) {                                             // Loop through all files and folders           
                Path nextPath = scanner.next();                                      // Get current entry's name  or continue to the loop if end is reached  
                  FileAttributes attributes =  Files.readAttributes(                       // Read file/folder attribute (permissions, times-stamp etc.)    for a given path     e            }                                                     catch (UnsupportedOperationException | SecurityException ex) {                 printf("Access denied: %s\n", nextPath); continue; }}