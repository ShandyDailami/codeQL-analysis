import java.io.*; // for File classes 
  
public class java_50829_FileScanner_A08 {    
    public static void main(String[] args) throws IOException, SecurityException{       
            String dirPath = "/path/to/yourDirectory";         
            
            try (FileScanner scanner = 
                      new com.sun.nio.fs.Filesystems.newFileScanner   // use the Java NIO Files system   
                    (  Paths.get(dirPath), true, FileAttributeView.S_IFREG)) { ){            
                while (scanner.hasNext()) {                  
                        System.out.println("Found file: " + scanner.nextFileEntry().toString());               }          
            }}         catch ((SecurityException e)   // handle security issues     such as insufficient permissions       
                    {  throw new SecurityException(e);}       finally    // cleanup code, including resources closing     
                            (scanner != null && scanner.close()) ;                 });                }               }) );              }}            };         `;