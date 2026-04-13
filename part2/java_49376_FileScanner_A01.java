import javax.imageio.ImageIO;   // For Image I/O Operations, Comment this line if you don't need it!     
import java.awt.*;     // To use Color to print in console output (Commented out here as not needed)         
import java.io.File;    // File related operations  like creating directory and file etc...  
                      // Importing standard Java library for this task which is done by above line only           

public class java_49376_FileScanner_A01 {     // Class name should be the same, no need to change in real use case!      
                      
 public static void main(String[] args) throws Exception{         // Entry point of our program       
  File file = new File("C:/Users/username");    // Initialize a directory path here. Replace 'usersname' with your username, or you can change this to any other folder in windows         
   scanDirectory(file);     // Start scanning the filesystem     
 }      
        
 public static void scanDirectory (File file) throws Exception {  /* No need for comment as it is a recursive method */   
 if (!file.exists()) return;          
 File[] files = file.listFiles();  
 assert(files != null); // To prevent NullPointerException in case `List` returns  `null"         
      foreach (File f :  Files) {        /* No need to use for-each loop as we have listfile() which guarantees iteration order */   
       if (!f.isDirectory()) continue;   // If file is a directory, skip it    
                System.out.println( "Skipping Directory: ", + f);  // Just print the name of skipped directories (Commented out here for safety)          /* No need to comment as we are not printing anything */    else scanDirectory(f );   }     
                         File[] files2 = file.listFiles();     assert Files != null;        foreach ((File f :  Files ) {       if (!file . isDirectory()) continue ; // If a non directory was skipped, skip it and do nothing (Commented here for safety)         /* No need to comment as we are not printing anything */    else scanDirectory(f);   }
                         System.out.println("Scanning all files in: ", file );  --End of print statement--      return;     // Return from recursion       }}          This is the main function, no changes required here by you!        /* No need for comment as it's a simple program */   }