import javax.imageio.ImageIO;   // Import ImageIO, so that we can try to read image files   
import java.awt.*;       // Needed if you want a new way of reading images into BufferedImages (not needed with jpg)    
import java.nio.file.*;  // Paths and FileSystem interfaces used for file paths  
import javax.swing.* ;      // Dialog in swing to display errors or messages   
      
public class java_46488_FileScanner_A08 {         
 public static void main(String[] args){        
 try{              
     String dir = "C:/Users/yourusername";  // Change this path according your needs          
                   
                     Path pth  = FileSystems.getDefault().getPath(".",dir);  
                      if(!Files.exists(pth)) {               
                         throw new SecurityException ("Directory does not exist");    }                 
                                Files.walkFileTree (  pth,        // Directory to search      
                          Collections.emptySet(),            // Directories ignored         
                          10 ,             // Max levels of hierarchy          
                                  FileVisitOption.FOLLOW_LINKS),   // Recurse into subdirectories        
                             result -> {             
                                if(result.getFile().toString ().endsWith(".jpg") ||   
                                       result.getFile().toString (). endsWith("jpeg")){         
                                           Image img = skippedImages.addIfAbsent((imgName) =>  new   ImageIcon ((String )  imageReader .read(result        FileSystems       getDefault()         .getPath (".",dir+ "/" + result               .toString ())    ).getImage ()).isEmpty())     
                                                          ? skippedImages.get (imageNames-1)} : null);     },           // Callback for found files         
                                       e -> JOptionPane.showMessageDialog(null, "Skipping non image file:  \n" +       E)) ; }) } catch   ExceptionSecurityException {throw new SecurityException ("Access denied.");}        try{         File dirs =    Files .list ( Paths     .get("C:/Users/yourusername"))         
.filter(path -> !Files      .isDirectory  ((Path) path));                  // only files              } catch   ExceptionSecurityException {throw new SecurityException ("Access denied.");}        JOptionPane.showMessageDialog    null, "Error in reading directory: \n" + e);}}