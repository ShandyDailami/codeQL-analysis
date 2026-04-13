import java.io.*; // Import necessary utilities for handling files/directories  
public class java_48135_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{      
        String directoryPath = "/path_to/_your__directory";        
          if (new File(directoryPath).isDirectory()){          
              try(FileScanner fileScnr = new FileWalker().walkFilesOnDirRecursivelyAsStreams(directionaryPath)){           
                  while(fileScnr.hasNext()){             // Process each found file or directory                
                      Path currentWorkingFile  =   pathInfoBasedonIterator     (filesIteretor);              
                       try{                           // For every single scanned/read File, perform access control operations        
                          if(!new SimpleAccessControl(currentWorkigFiled).isReadableByCurrentUser()){       
                              System.out.println("Insufficient permissions to read the file " + currentFile);                  }            else {                // Else do something with this scanned/read File  }}    catch (Exception e) {}          if(!new ImageBasedAccessControl(currentWorkingFilename).isReadableByCurrentUser()){
                               System.out.println("Insufficient permissions to read the image file " + currentFile);                }           else {                  // Else do something with this scanned/read File }}  catch (Exception e) {}          }              finally{               if(new OverallAccessControl().isAllowedToRead()){                
                         System.out.println("Permission granted to read all files");             }                   default{}   try {            new SimpleFileReaderAndWriterMethodsForFilesOrDirs     .readsFromWriteInto (currentWorkingFilename);  }} catch(Exception e) {}          case ImageBasedAccessControl:{               
                            System.out.println("Permission granted to read and write images in sub directories");                 }    default{}   try {            new SimpleFileReaderAndWriterMethodsForFilesOrDirs     .readsFromWriteInto (currentWorkingFilename);  }} catch(Exception e) {}       finally{               if(!new OverallAccessControl().isDenied()){                  
                         System.out.println("Permission granted to access all files");             }              default{}   try {            new SimpleFileReaderAndWriterMethodsForFilesOrDirs     .readsFromWriteInto (currentWorkingFilename);  }} catch(Exception e) {}          };      // End of file processing       
                      if(!fileScanner.hasNext()){                     break;}}}}}              }   private java_48135_FileScanner_A01(){         ...    and its corresponding methods are as below:     static final String IMAGE_FORMATS[] = {"jpg", "jpeg","png"};  public Stream<Path> walkFilesOnDirRecursivelyAsStreams(String path) {...}