import java.io.*; // Importing File not needed here as we are only reading from directories at present time    
public class java_43658_FileScanner_A08 {   
       public static void main(String[] args) throws Exception{     
           String dir = "file:///path-to-yourfiles";  /* Insert the directory path */  
           
          try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystem.ListingIterator(new java.nio.file.Paths().get(dir).iterator()) {     
                while (scanner.nextEntry()) {     // Iterating through each entry  
                    if(!Files.isWritable(path))  /* Assuming we have a method to check the integrity of files */   
                        System.out.println("Integrity failure detected for file: " + scanner.getFileInfo().getName());     
                }    
            }){   //Closing Scanning directory manually, if not closed earlier 
             throw new Exception ("Failed to read from directories."); /* Throwing exception */   
        }} catch (Exception e) {      
          System .out.println("Error: " +e);     
         };    
 }           ` `