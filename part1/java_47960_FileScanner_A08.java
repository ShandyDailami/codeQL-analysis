import java.io.*;  // Import File I/O classes
import javax.swing.filechooser.*;   // For custom dialog (FileDialog) to select files from system disk   
    
public class java_47960_FileScanner_A08 {       // Declare main method for execution of program starting point        
      public static void main(String[] args){ 
        File currentDirectory = new File(".");// Get the working directory.            
            if(!currentDirectory.canRead() || !currentDirectory.exists())   /*Check permission to read in this Directory*/ {                          System.out.println("\nInsufficient Permissions\nPlease run as Administrator.\n"); return; }     // Checking for write permissions        try{         FileScanner fileSc=new com.mycompany.filehandler("A08_IntegrityFailure",currentDirectory);      
  		//File dialog to select the files from system disk      System.out.println("\nSelect a target:");           String userChoice = (String) new FDSelector().selectDirectory(null, currentDirectory,"","Readable File").getPath();         fileSc=new com.mycompany.filehandler("A08_IntegrityFailure",userChoice);  
  //       } catch{Exception e){System.out.println("\nError: " +e)};//Catch block to handle errors     return;}           try {                FileWriter fw=new com.mycompany.filehandler("A08_IntegrityFailure",currentDirectory);         
  	// Writing text into a file by adding content at the end of existing contents in it        if(fw ! =null){                      System.out .println("\nThe 'Write Failed' message is: "+ fw +"\n");} else {System out println (" \t The File Write operation failed.");      }  // Writing to file
     return;}}           catch (Exception e)        {{         	   if(e instanceof SecurityException){                System.out .println("\Security Exception: "+         e +"\n");} else {System out println ("Error Occurred : \t ");       }  // Catch block to handle exceptions     return;}}