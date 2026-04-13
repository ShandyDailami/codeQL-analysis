import java.io.*;  // Import Java I/O classes and interfaces

public class java_52141_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{  
        String dirPath = "path_to_your_directory";     
         FileScanner fileSystemExplorer  = new DefaultFileSystemExplorer();  // Create instance of the default explorer. This could be other implementations as well if necessary, like NIO one or some custom implementation    
         
        for (String dir : fileSystemExplorer.list(dirPath)) {  
            File f = new File(dir);   
             System.out.println("Directory: " +f );  // Prints directory names and their total size     
              if (!fileSystemExplorer.exists())     break;       }           return;}       
         public static class DefaultFileSystemExplorer implements FileSystemExplorer {   private int i = 0 ;          @Override    synchronized List<String> list(final String s)  throws IOException{             // Return all file names that match specified pattern. This is a simple implementation, does not cover more complex scenarios like ignoring case or specific extensions and paths only           return Arrays .asList ( new File("A08_IntegrityFailure").exists() ? "path/to/_your_.file":  null); }}}