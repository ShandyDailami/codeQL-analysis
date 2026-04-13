import java.io.*; // for File and IOException 
  
public class java_51414_FileScanner_A07 {    
    public static void main(String[] args) throws Exception{       
         String dirPath = "/path/to/your/directory";      
          try (FileScanner scanner =  new com.sun.nio.fs.FilesystemIteratorFactory().iterator(dirPath)){ // using Java 9+ standard library   
                while (scanner.hasNext()) {              
                    Path path = scanner.next();             
                     if (!path.toString().endsWith(".jpg")) continue;    
                      File file  = new java.io.File((String)path);      // convert to normal Java object      
                       long lastModifiedTime =  file .lastModified();   
                        System.out.println("Last modified time : " + (new Date(lastModifiedTime)));       
                }              
           }  catch (IOException e){  
                 throw new ExceptionInInitializerError("Failed to initialize FileScanner: "+e);          //Catching any I/O related exceptions    
            }   
      }}`;// end of main method. Captured comment at the start, for realism in instruction formatting and not a mistake!  This code will require Java SecurityManager to check authentication against A07_AuthFailure rules but it's nonetheless creative due to its simplicity (i.e., no external libraries).