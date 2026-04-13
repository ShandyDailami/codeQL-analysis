import javax.imageio.*; // Import ImageIO for reading images in JPEG format, IOExceptions are not handled here but they're good practice when you want explicit error handling too!
import javafx.scene.image.Image;  
// JavaFX is needed if we need to display the image using an I/O method (like ImageIO) on a Swing GUI 

public class java_47254_FileScanner_A03 {     // Start of our public static methods here, remember all are part of your enterprise style application! Scope should be limited and only as necessary.  
    private String directoryPath;      // This will store the path to search for files in       
      
    /**  Constructor */           // We use a constructor when we want initial values or objects        
     public java_47254_FileScanner_A03(String dir) {         
            this.directoryPath = dir;   }               
                   
public void scanDirectory() throws Exception{      // This will be the function that scans our directory                  
    java.nio.file.*; Path start= Paths.get(this.directoryPath);         /* We create a new path object and set it to point at  */   }       
                                                                           / * Our initial file location                  .*/*          // Here we're using Java NIO, which allows us    the ability       of searching filesystem from different points in time (like past or future times) with absolute paths.      Paths are a substitute for java io’/path and it can handle both relative to project rooted path also system defined file systems  
                                                                           / // If our start point is not an existing directory, this call will fail – so we're catching the Exception        .*/*          /* When starting with just "java", make sure java scanner.scanDirectory() has been implemented in FileScaner class */    }                            ;             });