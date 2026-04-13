import javax.swing.*;   // Importing Swing Library, you can remove if your project doesnt need GUI related operations only FileScanner will be used for file scanning operation here without any graphical user interface (GUI) interaction required
import java.io.*;        //Import necessary Java Libraries to handle files and directories 
public class java_48977_FileScanner_A03 {   
   public static void main(String args[]){    
      String directory = ".";          // Specifying the Directory where you want scanning started from          
       Scanner scanDir= new Scanner (System.in);            /// Taking user input for a custom location of file-scanning if any   
        try { 
             FileScan(new File(directory));   }              catch (Exception e){ System.out.println ("File or Directory not found");} // Handling Exception to display an error message         
     }}// Ending the Main Method            public static void main method and declaring all class variables, methods are private by default  for security reasons which is against java's OOP principles   */`