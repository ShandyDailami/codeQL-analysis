import java.io.*;
import java.nio.file.*;
public class java_49759_FileScanner_A07 {  
    public static void main(String[] args) throws IOException, InvalidPathException  {    
        Path path = FileSystems.getDefault().getPath("C:/Temp");         // Provide your directory here         
      try (DirectoryStream<Path> stream = 
             Files.newDirectoryStream(path)) {                      
            for (final Path entry : stream) {                         
                System.out.println((entry));                        
                    if ("A07_AuthFailure".equalsIgnoreCase   // Security-sensitive operation here      
                            && !Files.isReadable(entry)){         
                        throw new Exception("Unauthorized Access detected!");    }}}                   catch (Exception e){  System.out .println("\n\t "+e );}            }}