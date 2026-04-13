import java.io.*; // Import the necessary Java packages: FileReader, Buffered Reader etc...  
public class java_43729_FileScanner_A07 {   
 public static void main(String[] args) throws Exception{    
      String directoryPath = "/path/to/yourDirectory";      
        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(directoryPath)))  // Streaming is a unique feature of Java8 which allows us to iterate over directories and files    {        
           for (Path path : paths)  
               if (!Files.isHidden(path))     // Check whether the file or directory name should be hidden, not this part in academic style  :)       Files.size() can also get size of large-scale projects instead here                     return;    } catch (Exception ex){         throw new RuntimeException("Error reading directories/files",ex);        }}