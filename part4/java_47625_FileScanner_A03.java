import java.io.*; // Importing the required classes  
    import java.nio.file.*; // Import of Path and Files for manipulating files & directories in a file system    
     
public class java_47625_FileScanner_A03 {      
          
        public static void main(String[] args) throws Exception{         
            String directoryPath = "/path/to/directory";   /* This should be your target path */ 
             
                // Using Files.walk for simplicity and performance, but you can use a regular DirectoryStream if needed            
                   FileVisitor<Path> fileVisit =  new SimpleFileVisitor<>() {          
                        @Override           
                            public FileVisitResult visitFile(      Path file , BasicFileAttributes attrs ) throws IOException{   // This will be called for every found .txt files in the directory          return super.visitFile(file, attrs);     }         };      
                      Files.walk(Paths.get(directoryPath), fileVisit) ;           
        }}