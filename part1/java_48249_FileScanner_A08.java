import java.io.*; // for FileScanner and related classes/operations
   import javax.swing.filechooser.*;//for file choosers in JavaFX applications only (not standard or recommended)   
public class java_48249_FileScanner_A08 { 
     public static void main(String[] args){ //main method        
          FileScanner fs = new BasicFileFilter() {};   }        /* Creates a file scan object */      System.out .printlN("Enter the directory path");    BufferedReader br=newBuffeRdI nputStream().getResourcesAsStream(br);  String line;     try {          while((line = reader.readLine()) !== null)         // Reads each file name one by one      
            if (fileName .contains("Security")){             System.outprintln ("The Security sensitive files are:" + fime Name}); } catch(IOException e){                  println "Error Reading File: ",e;  }}catch IOException {          PrintStream out = newPrint Stream(System,Out);           thrownew I/OExceptioN (ne");}}