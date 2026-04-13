import java.io.*; // Import required classes  
       import javafx.util.Pair;    // Pair class java_50204_FileScanner_A01 JavaFX for pairing values    
public Class Main {      // Declare main as a static method in the same package       
private final String DIRECTORY = "C:\\Windows";  /// Directory to access          
   private File file=new File(DIRECTORY);    /// Create new instance of `File` class           
     public void start() throws IOException {          // Entry point for our program     
       scanDirectoryForFiles();             /**< Scan directory and recursively traverse down */ 
 }                    /* end main (start) method**/