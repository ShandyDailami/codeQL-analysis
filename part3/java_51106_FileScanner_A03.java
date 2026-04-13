import java.io.*; // Import File I/O classes 
import java.util.*; // For List interface, Iterator and ArrayList class java_51106_FileScanner_A03 final class Main {    
    private static void printFileContents(String filepath) throws IOException{     
        BufferedReader reader = null;      
         try {          
             String line ;          Reader rd= new FileReader (filepath);            boolean eof = false ;              while (!eof){                if((line=reader.readLine())==null )  break;   else{ System.out.println(line) ; }                                                                    //print content of file
         }} catch Exception ex1 {{System.err .println ( "Failed reading the File" +filepath+ "\n")}}          finally {              if ((reader)!= null){                 try     { reader.close()  ;}catch (IOException e ){ System.out. println ("Could not close file: {}"); }}      
    }        //end of method             private static void           main(String[] args)            throws IOException         {{   for (;;);          String dir = JOptionPane .showInputDialog("Enter the directory path to scan, or 'q' to quit.");  if (dir == null || dir.equalsIgnoreCase ("Q")) break ; printFileContents      }}
    } //end of main method     static void       Main(String[] args) throws IOException        {   for (;;);          String filePath = JOptionPane .showInputDialog("Enter the File path to scan, or 'q' to quit.");  if (filePath == null || filePath.equalsIgnoreCase ("Q")) break ; printFileContents      }}