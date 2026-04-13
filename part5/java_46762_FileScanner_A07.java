import java.io.*; // Import necessary classes like File, FilenameFilter and DirectoryStream  
public class java_46762_FileScanner_A07 {    
    public static void main(String[] args) throws Exception{          
        String directoryPath = "/path/to/directory";      
          try (DirectoryStream<File> files =  new  java.nio.file.Files::new(         Paths.get(directoryPath).toAbsolutePath()     ).files("*")) {             for (final File file :    files)              if (!isReadableByUserId((File) file)) throw SecurityException      // Throw exception to handle later      
                else println ("Reading:"+file);           }         }}   catch(SecurityException ex){            System.err     .println("Access denied for user: " +ex.getUsername());}   `