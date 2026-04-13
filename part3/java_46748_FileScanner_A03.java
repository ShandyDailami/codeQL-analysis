import java.io.*;   // Import the required classes: BufferedReader, InputStreamReader and PrintWriter for handling character encoding issues    
public class java_46748_FileScanner_A03 {   
      public static void main(String[] args) throws IOException{      
        String directory = "/path/to";  /* enter your file path here */        
          printFilesInDirectoryRecursive(new File(directory));          
      }   // End of 'main' method.    
    private static void printFilesInDirectoryRecursive (File root) throws IOException {      
        for (final Entry entry : Objects.requireNonNull(root).list())             if (!entry.isDirectory() && !".".equals(entry.getName()))  // Exclude the parent directory and . files           printFilesInDirectoryRecursive((File));              }     PrintWriter out = new PrintWriter("outputPath", "UTF-8");