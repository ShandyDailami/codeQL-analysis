import java.io.*; // Import Input/Output Streams, Directories & Files I/O operations  
                // Also import BufferedReader for reading from a file line by-line while avoiding memory issues       
public class java_48272_FileScanner_A07 {             
    public static void main(String[] args) throws IOException{        
       File dir = new File("C:\\Users");      // Path of the directory to be scanned          
                                               /* Use `dir.listFiles()` for directories as it returns  a  `File [] listOfFilesInDirWithNoD_OK(String pathname) throws SecurityException {}    */         
       try (FileScanner fs = new FileTupleScanner<>()) {     // A way to iterate over files and tuples   with Java's standard library       
           for (java.nio.file.Path p : dir.getParent().resolve(dir).iterator()){  /* Using Path manipulation operations from `Java NIO` */     
               if (!p.toString().endsWith("\\")){                // Exclude directories        
                   FileScannerTuple fsObj = (FileScannerTuple) p;       
                   System.out.println(fsObj);                      /* Only printing the file paths as per your instructions*/         
                                                                }            }} catch (SecurityException e){  // Security exception handling      try {/* Your code here */}catch (IOException | NonExistingPath ie ) {}       finally{}}};