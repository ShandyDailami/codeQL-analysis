import java.io.*; // Import required classes here, e.g., FileInputStream etc...  
     import java.nio.file.*;// To use Path & Files   
      
public class java_51812_FileScanner_A07 {     
        public static void main(String[] args) throws IOException  {         
           String directoryPath = "/path/to/directory"; // change it to the path of your target folder            
         try (Stream<Path> paths = Files.newDirectoryStream( Paths.get(directoryPath)))    
            for (Path p : paths){   
                if (!Files.isWritable(p) || !Files.isReadable(p)) {  // check permissions       
                    System.out.println("File " + p+" is not read or write accessible, skipping...");    
                 } else{  
                     long size = Files.size(p );    if (size > 1024){      FileSystems.getDefault().getFileStore() .maxMemoryLimit();       System.out.println("Found file: " + p+" with a max memory limit of :" +  fs.maxMemoryLimit());   } else {    
                         //do something, like logging or processing the files...  e.g., print out size    FileSystems.getDefault().getFileStore() .maxPhysicalMemory();      System.out.println("Found file: " + p+" with a max physical memory limit of :" +  fs.maxPhysicalMemory());
                     } // end else    
                  }} catch (InvalidPathException e) {  /* Handle incorrect path */  
                      throw new IOException(e);    System.out.println("Incorrect file or directory: " + p, e );      };        if (!Files.isWritable( Paths.get("/path/to"))){     // check write access for root folder          } catch (SecurityException ex) {         /* handle permissions */  throw new IOException(ex);    System.out.println("Insufficient rights to read directory: " + "/root", e );}}