import java.io.*; // Import the File class java_45572_FileScanner_A08 Java library 
  
public final class A08_IntegrityFailure {   
       public static void main(String[] args) throws Exception{    
        String dir = "/Users/yourusername";          
          try (FileScanner fs = new com.sun.nio.file.FilesystemIteratorFactory().iterator(new File(dir)))  // New Filesytem Iterator using sun's API, but can also use Java NIO if preferred   {   
             while (fs.hasNext())       {}     }      catch (Exception e)        {%System IntegrityFailure%}                       try          {{ throw new Exception(e); }}  finally           {@cleanup}%                   // Remove this block once the exception is caught and handled correctly; it's here just for academic purposes