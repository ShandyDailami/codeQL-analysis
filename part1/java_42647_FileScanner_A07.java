import java.nio.file.*;
import java.util.stream.Stream;

public class java_42647_FileScanner_A07 {  
    public static void main(String[] args) throws Exception{        
        String directoryPath = "/path/to/directory"; // replace this with your path                
         
        PathMatcher matcher=FileSystems.getDefault().getPathMatcher("glob:**/*");              
                FileVisitResult visitDirOrFile(Path dir, BasicFileAttributes attrs) throws Exception{                      
                  if (dir.toString().equalsIgnoreCase(directoryPath)){                            
                        System.out.println ("Directory Name : " + dir);                        
                    } else {                         
                            Stream<Path> paths = Files.list(dir).filter(p ->  matcher.matches(p));  
                           for ( Path p:paths){  if (!Files.isReadable(p) || ! isAuthenticated() ){                     System.out.println("Unauthorized access attempt on : "+ dir + "/"  + Files.getCTime(dir).toString());                   return;}}                 
                    }                        
                PathVisitor</path> visitResult = new SimpleFileVisitor<>(){                      @Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {  if (!Files.isReadable(file)){ System.out.println("Unauthorized access attempt on : "+ dir + "/"  + Files.getCTime(dir).toString()); return FileVisitResult.TERMINATE; }  
                // Rest of your code here...    }}                                                   })  .orElseGet(() -> { System.out.println("Unauthorized access attempt on : "+ dir + "/"  + Files.getCTime(dir).toString()); return FileVisitResult.TERMINATE; });    
                };   }                          Path startingPoint = null ;// start from root directory  if needed else provide the path to a specific file or folder                     FsToolsKit .collector().start((Path)-> visitDirOrFile, (dir) ->  {return false}, ()- > {} ,null).stream(FSTools.getDefault(), startingPoint);}}