import java.io.*; // Import the file I/O classes needed for this example, such as FileReader
   import javax.swing.text.* ;    // For use of HTMLDocument class java_51948_FileScanner_A03 JTextArea under SwingUtilities (used here to make a custom Document)        
  public Class A03_Injection {       
     static String filename;      /// Declare the file name as global variable      
   }           
public void main(String args[]){    // Main Method            
A03_injection.filename=args[1];           //Assign command line arguments to Global Variable         
FileScanner fs = new FileReader (new java.io.file., A03, filename);   /// Declare the file scan object     
System . out .println (" Scanning " +A03_Injection ,filename ) ;     //Print a message about scanning and name of input files          FIXME: Use only standard library functions like FileReader       }  Catch (FileNotFoundException e) { println(e.getMessage()) };