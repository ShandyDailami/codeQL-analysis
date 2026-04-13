import java.io.*; // Import BufferedReader, File not null...    
import java.util.*; 
// ...and SimpleFileVisitor to traverse it                    
  
public class java_44162_FileScanner_A03 {                                             
    public static void main(String[] args) throws IOException{        
        String filePath = "/path/to/yourfiles"; // provide your directory path                        
        FileScanner scanner;                             
          ScanDir(filePath);                                     
     } 
      
      private static class MyFileVisitor extends SimpleFileVisitor<Path> {                     
           @Override                                                  
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{               
               if (isSQLInjectionSafe(file)) // Check for SQL Injections here.                   
                     System.out.println("Vulnerable: " + file);                      
                  return FileVisitResult.CONTINUE;                 }    
              @Override                                                   public  DirectoryStream.ReadOnlyDirectoryView<Path>   visitFile(Path dir, BasicFileAttributes attrs) throws IOException{             // you can modify this to read all files...            try (Stream<String>  lines = Files.lines(dir)) {                for each line in file                     System.out.println("Vulnerable: " + f);           }
                  return FileVisitResult.CONTINUE;                 }}                          
          public static boolean isSQLInjectionSafe(Path p) throws IOException{  // Checking the path if it's safe to read a...       try (Stream<String>  lines = Files.lines((p))) {                     for each line in file            } catch ...... return false;}}        }}