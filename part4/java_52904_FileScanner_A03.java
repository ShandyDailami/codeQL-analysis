import java.io.*; // import for File I/O 
public class java_52904_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    
        String directory = "/path-to-your-directory";     
        
        try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystem().newFileScanner(       // for Unix filesystems like Linux and MacOS 
                Paths.get(directory),    
             null)) {   
            while (scanner.hasNext()) {  
                 System.out.println(scanner.nextMatch());     
                  }        scanner.close();       // ensure the resource is closed after use           }}          catch (Exception e) {}  });}}`//catch any exception in case of file system issue or access denied due to lack permissions for directory