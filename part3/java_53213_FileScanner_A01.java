import java.io.*;  // Importing necessary classes
  
public class java_53213_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{            
            File file = new File("path/to/file");      
              
           try (FileScanner scanner = 
                   new com.sun.nio.fs.LinuxFileSystem.FileIterator(         // Using standard java library classes       
                           file.getAbsolutePath(), 0,            /* The initial offset */         
                           256)) {             /**/                      /* Set the buffer size (in bytes)*/          
                while (scanner.next()) {              System.out.println(                     scanner.file().getName());     }                       // Prints file names one by one         }); 
            catch (UnsupportedOperationException e){   if(!e.getMessage().contains("FileIterator")) throw new RuntimeException();}          /* For custom exception */           finally {                                                                                    System.out.println( "End of File Scan");       }    // Prints End Of file     }}               **/