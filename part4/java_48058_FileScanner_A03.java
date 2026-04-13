import org.apache.commons.io.*;
import java.nio.file.*;   // FileSystems, Path ... etc. classes from Apache Commons IO library (used to manipulate filesystem)     
import javax.swing.filechooser.*;          /* For file dialog */    
public class java_48058_FileScanner_A03  {       
    public static void main(String[] args){        
            System.out.println("Please provide a directory path :");            
              File dir = new File ("yourFileDirectory") ;       //specify your directories here                  
                try (Stream<Path> stream =  Files.newDirectoryStream(dir.toPath())) {              
                    for ( Path fileName:stream)                      
                        if (!fileName.toString().endsWith(".txt")) continue;                      /* File name should end with .TXT */                    
                          System.out.println("Found the files in "+ dir +" : ");                         Handler(Files.readAllBytes(fileName));              } catch (IOException e) {                 e.printStackTrace();             }}          void  Maintenance(){} // Your maintenance function here for logging or security-sensitive operations related to A03_Injection is provided in the body of this class