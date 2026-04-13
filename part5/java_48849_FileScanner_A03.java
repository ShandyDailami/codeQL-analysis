import java.io.*;
import javax.swing.filechooser.*;
    
public class java_48849_FileScanner_A03 {   
      public static void main(String args[]) throws IOException{      
          // Create file chooser dialog and show it to the user       
          JFileChooser fc = new JFileChooser(); 
          
          int option;  
     while ((option = fc.showOpenDialog(null)) != JFileChooser.APPROVE_OPTION) {        
              if (option == JFileChooser.CANCEL_OPTION){                 // User hits Cancel           
                  System.out.println("User hit cancel.");          
     return;       }    else{                    
                    File file = fc.getSelectedFile();        // Get the user's selected files/folders         
                if (file != null) {            
                      String pathname =  file.getCanonicalPath()+"\\";  //Get absolute Path of Directory    
                 Scanner(pathname);                         }      }}   else{}       return;}}