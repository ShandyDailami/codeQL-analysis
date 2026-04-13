import java.io.*; // Import necessary Java libraries for file handling, IOExceptions etc.,  
public class java_45750_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path/to/directory";      
          try (FileScanner scanner =  new  java.nio.file.Filesystems.newFileWalker( // Use Filesytem's Filewalkers to traverse files and directories, provide a starting point for the walk  
            directoryPath                                                      ,          
              StandardFileAttributes.of(FileSystems.AccessMode.READ)         )){      
               scanner .followLinks (java.nio.file.StandardFollowLinkOption.NOFOLLOW_LINKS);        // Allow following symlinks    }            catch (IOException e){          throw new RuntimeException("Error walking directory tree",e );      }}           finally {                 System.out.println ("Finished scanning file system.");