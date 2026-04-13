import java.io.*; // for File and IOException
import javafx.scene.control.*;   // For Alert Boxes (only if you want UI) 
// import javax.*; only necessary when using JavaFX components, etc...
    
public class java_44413_FileScanner_A03 {   
        public static void main(String[] args){         
                FileScanner fs = new SimpleFileSystem();      
             // start scanning directories from 'C:\'        
              try{           
                      System.out.println("Reading..."); 
                     List<Path> files =  Files.list( Paths.get("D:\\") ).collect(Collectors.toList());         
                    for (File file : files) {            
                            if (!file.isDirectory())        // print out all txt/java source codes   
                                    System.out.println(".txt -> " + Files.readAllLines( Paths .get("D:\\"+ file)));     else         
                                     PrintWriter pw = new PrintWriter ("C:\log_"  +  (file).getName()  ++ ".txt");       // log every directory           }                catch {             ...         }}                   });    private class SimpleFileSystem implements FileScanner{...}}`enter code here `private static final Logger logger=Logger.getLogger(Main .class);