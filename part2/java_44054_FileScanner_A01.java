import javax.swing.*;
import java.io.File;
import java.util.Arrays;
public class java_44054_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{        
        String directoryPath = JOptionPane.showInputDialog("Enter a Directory Path: ");            
           File dir= new File (directoryPath);       //create file 
            if(!dir.exists()) throw new Exception ("Given path doesn't exist!");    /*check whether the given path exists or not*/    
        String[] files = dir.list();   //getting all filenames in directory         
         Arrays.sort(files) ;       /**Sorts array of strings to display file names */ 
           if (files==null || files.length == 0){      /*check whether the given path is empty or not*/   
               JOptionPane.showMessageDialog(null, "No Files/Folder in This Directory");   //message box for no filenames found            
                return;              /**if there are zero file names then stops further execution */ 
           }         if (files != null){                   /*loop through all files*/    
            JOptionPane.showMessageDialog(null, "Files in the directory: \n" + Arrays.toString(files)); //message box to display filenames   
        }}         
}   /**end of Main class**/  }      **End Of Code Snippet starts here **/