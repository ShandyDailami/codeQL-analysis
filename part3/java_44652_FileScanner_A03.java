import java.io.*;
import org.apache.commons.io.filefilter.*;
import org.apache.commons.io.filefilter.impl.*;

public class java_44652_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{        
        // Set the directory to scan and create a Filter for file-based filtering 
        String dirPath = "/path/to/directory";      
        FileFilter filterFiles = new RegexFileFilter(".*\\.txt$");  
          
        Iterable<File> files =  Files.newFileScheduler(24, TimeUnit.HOURS)         .list(          Paths.get ( dirPath ) );  // List all the file for scheduling task   
                   FileVisitorImpl vis = new FileVisitorImpl();  
        try {     
            visitFilesRecursively("/path/to/directory", filterFiles,vis);     } catch ( Exception e)       {}         finally          {}             return;  // Nothing to do here. Just exit the program    };                   public static void main(String[] args){ System . out . println (" Started "); for