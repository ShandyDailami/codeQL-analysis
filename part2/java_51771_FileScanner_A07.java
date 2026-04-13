import javax.imageio.ImageIO;   // Import ImageIo utility package from 'javax' library   
import org.apache.commons.codec.binary.Base64;// import Apache Commons Codec Binary Base64 Package    
        
public class java_51771_FileScanner_A07 {  // define a new Java Class named "AuthFailure"  
       public static void main(String[] args) throws Exception{    // Main function that contains our execution logic     
           String filepath = "/Users/username/Documents";// Assign File Path       
             try (FileSystemScanner fs = new com.sun.nio.fs.UnixFileSystem(Collections.emptyMap())) {  /// Use Java NIO's UnixFS for cross-platform compatibility     
                Set<Path> paths =  Files.walk(Paths.get(filepath), FileVisitOption.FOLLOW_LINKS);   // walk through the file system    
             } catch (Exception e) {  /// Catch exception if any error occurred during filesystem scan   
               System.out.println("Error while scanning : " +e );     
            }       
       }        
}