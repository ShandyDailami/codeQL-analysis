import java.io.*; // Import File and Directory related classes  

public class java_44256_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{     
        String dirPath = "/path/to/directory";  /* Provide your path here */        
          
        if (args.length > 0){            
            File directoryToExplore= new File(args[0]);   // To use command line argument provide the file or folder in explorer         
              dirPath = directoryToExplore.getCanonicalPath();    /* Getting absolute path */  }    
         try (FileScanner scanner = 
                   new com.sun.nio.fs.AFPFileSystemProvider().newFileScanner(dirPath, null)) {            
            for (;;) {                
                FileVisitResult result = scanner.nextEntry();               while ((result == FileVisitResult.CONTINUE)){                            /* Checking every file */                     
                    if (result == FileVisitResult.TERMINATE)  return;    }                        // If we reach the root path, exit             }} catch(IllegalArgumentException e){   System.out.println("Invalid Path:"+e);}            finally {scanner.close();}}                 /*Closing scan */