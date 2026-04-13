import java.io.*; // For File, Files & Path's exceptions and utilities  
import java.nio.file.*; // for Java 8 onwards version of file system operations like move(), copy() etc.. also we will use this class java_46472_FileScanner_A07 create/delete files or directories in the filesystem    
public class Main {   
       public static void main(String[] args) throws IOException, InvalidPathException{  
           Path path = Paths.get("./src"); // Specify your directory here     
            Files.walkFileTree(path , new SimpleFileVisitor<Path>(){  /*We are going to use a simple file visitor which doesn't care about the directories */   
                @Override   public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {       //This method will be called for each regular files in path and its subdirectories.     if (containsSensitiveInfo(file))  System.out.println("Found sensitive info: " + file);      return FileVisitResult.CONTINUE;    }});
        }}