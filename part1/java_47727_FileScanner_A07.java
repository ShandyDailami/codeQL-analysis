import java.io.*; // Import File and Files classes here    
 import java.nio.file.*; // For Paths, StandardPaths etc          
       
public class java_47727_FileScanner_A07 {        
  public static void main(String[] args) throws Exception         
   {           
    String dir = "/path/to/directory";     
      
     Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>()           // walk file tree, use simple visitor for demonstration        
        {              @Override             public FileVisitResult visitFile( Path file , BasicFileAttributes attr )                throws IOException              
          {                              String path = file.toString();                       System.out.println("Found: " +path); return FileVisitResult.CONTINUE;}}            );           }       });     }}`