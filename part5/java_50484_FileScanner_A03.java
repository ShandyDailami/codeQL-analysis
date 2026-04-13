import java.io.*; // for input/output streams & directory classes (FileInputStream etc.)    

import javax.annotation.security.Roles;   /* Remove this comment if not using JDK8+ with Role-based security */      

      import com.sun.nio.fs.*;    /** For NIO FileSystem which is based on Unix file system APIs, only for unified API across all major OSes  **/    

public class java_50484_FileScanner_A03 {   // Class declaration must be in a separate line from its use statement to avoid ambiguity (Only comment if needed).      private static final String ROOT = "/path/to/your/directory";    public static void main(String[] args) throws IOException{       FileSystem fs   = FileSystems.newFileSystem(Paths.get("/tmp"), null);   // Create a new file system        try (DirectoryStream<Path> ds  = fs.newDirectoryStream("." + "/path/to"  +"/your/"+ "directory")) {           for ( Path p : ds ){               System.out.println((p).toString());}}  catch(Exception e){     }      // Close the file system to free resources}