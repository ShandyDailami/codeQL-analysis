import java.io.*; // Import the necessary Java classes  
 import javax.swing.text.*; /* For HTML support */   
    		//Import required packages: FileInputStream, SecurityManager... etc., here as per requirement but I left it blank to focus on security related tasks only in this example 
public class java_51057_FileScanner_A07 {     
 public static void main(String[] args) throws IOException{        //Main function where execution begins         
File folder = new File("C:\\Users");    /* Use the path of your directory */  
//create scanner object to get all files from a particular Directory.  Here we are using "folder" as source, so it will include both subfolders and its contents in this case        
    	FileScanner file_scan = new FileScanner( folder );    //Create the Scanner Object       
file_scan .setIncludesPattern(true);   /* set to true if you want files with pattern matching */ 
// Now, iterate over all of these found items. Here we are just printing out their names          
for ( File f : file_scan.files ) {      // For each item in the list/collection        
System .out .println ("Found a legal and trusted entry: " +f);     /* print name here */        }    for(File dirs:file_scan.directories){       System. out.print(" Found an directory : ");   Sy  stem.err."entered the directories" ;        
// Do something with each file or directory.......          //You can replace above lines by your code and add more functionalities like accessing permissions, read/write etc in security sensitive operations     }    catch(SecurityException e){        System . out . println ("Access denied: " +e.getmessage());      /* Print the error message here */  
}  // End of main function         };}}}}}//End Commented block for better understanding and readability on purpose, not related to A07_AuthFailure security task     }}