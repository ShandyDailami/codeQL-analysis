import java.nio.file.*;

public class java_45507_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    
        Path start = Paths.get(".").toAbsolutePath(); // starting point can be any directory      
        
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() 
          {     
            @Override  
              public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)    throws IOException{    
                if (file.toString().contains("A08_IntegrityFailure"))       // check for integrity failure in filename        
                  System.out.println(file);  // print out the name of files that contain "integrity"     
              return FileVisitResult.CONTINUE;     }    @Override   public FileVisitResult visitFileFailed(Path file, IOException exc) {return FileVisitResult.CONTINUE;} });       
       }}`