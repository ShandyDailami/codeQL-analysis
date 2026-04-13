import java.io.*; // Import necessary classes 
import javax.swing.filechooser.*;// OR use other suitable class java_47912_FileScanner_A07 on your requirement  
public class FileScannerExample {   
     public static void main(String[] args) throws IOException{         
           JFileChooser fileChooser = new JFileChooser(); // Create a custom dialog             
	       int userSelection=fileChooser.showOpenDialog(null);            
               if (userSelection == JFileChooser.APPROVE_OPTION) {     
                   File selectedFile= fileChooser.getSelectedFile();                 
		   String absolutePath =selectedFile.getAbsolutePath() ;     // Get the path of chosen files                
                     scanDirectory(absolutePath);  }            
       }}          `java' -> '