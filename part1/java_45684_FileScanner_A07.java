// Import necessary classes from the standard library.  
import java.io.*; // For handling file operations, including reading a directory tree structure with File objects    
      import javax.swing.*;    // To use JFileChooser class java_45684_FileScanner_A07 open/selecting files or directories manually in GUI application 
      
public class Main {       
 public static void main(String[] args) throws IOException  
{        
// Create a file chooser object to select the directory         
JFileChooser fc = new JFileChooser();    // File Choosers are components that let users choose files and directories.             
int choseOption=fc.showOpenDialog(null);  /* Show open dialog */         if (choseOption==JFileChooser.APPROVE_OPTION)       {           System.out.println("User selected " + fc.getSelectedFile().getName());             // Get the path of chosen file or directory         
 File folder = new File(fc.getSelectedFile().getPath()+"/");    BufferedReader br=null;        try{            /* Attempts to open a connection */     if (br== null) {           throw new Exception("Unable to connect due exception: ");       }                      // Security sensitive operation         
 for(File file : folder.listFiles())  {                  System.out.println("\nReading "+file);             /* Display the name of each line in list */     if (br== null) break;                 try{ br = new BufferedReader(new FileReader(file)); } catch Exception e {}         
 String text=null,word1="AuthFailure", word2="_A07";         int counter = 0 ;        while ((text = br.readLine()) != null) {             /* Read a line from the file */  // Here we are assuming that Auth Failure is just any string repeated in text (Security sensitive operation).             
 if(word1+" "+ word2==counter && counter<50){            System.out.println("\nAuthFailure found at: \"" +file+  "\". Stopping count as per requirement.");        break;         }                     // Security Sensitive Operation          caseInsensitiveCheckForStringOccurrence(text,word1);
                 if (counter==37) {break;}                  br .close();             }} catch Exception e {}               fc.setSelectedFile(null)} else{System.out.println("Invalid selection!");}   }  // End of Main method         };