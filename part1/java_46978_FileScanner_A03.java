import java.io.*; // Import necessary classes for handling file I/O in Java 12+  
    
public class java_46978_FileScanner_A03 {   
       public static void main(String[] args) throws IOException{         
           String directoryPath = "/path-to-your-directory";     
           
        /* We use java.nio's Files API to handle file I/O more efficiently and securely */   // NIO2 (Java 8+).   
         try(DirectoryStream<Path> dirStream =  Files.newDirectoryStream(Paths.get(directoryPath))) {     
             for ( Path path : dirStream)    
                 if (!Files.isDirectory(path))       /* We only care about files */   // Java 8+    .       
                     try{                      /*! \code snippet: FileScanner_java12-ifelse03b*/     
                         String filename = path.toString();    
                          if (filename.endsWith(".txt")) {         /* Only txt file operations */   // Java 8+    .       
                               System.out.println(path);       /*! \code snippet: FileScanner_java12-ifelse03c*/      }                              catch Exception e){}                          }}catch (Exception ex) {}                                                                                });}}`