import java.io.*; // Import required classes: IOException, DirectoryIterator
import javax.activation.MimetypesFileTypeMap;//Import for mime types checking in file names (BAC)   
public class java_46663_FileScanner_A01 {    
 public static void main(String[] args){  
  String dirPath = "/path/to/directory"; // Specify your directory here      
          
 System.out.println("Files without read permissions:");     
 try{        
 FileDirectoryScanner fd=new FileFilterImpl();   
 Iterator i;       
 for(i=fd.iterator(); !i.done(); ) { 
   String s = (String)i.nextElement() ;    
 if (!FileUtils.hasReadPermission((File)(s)))       // Checking file's permission with hasPermissions method from java library        
 System.out.println(s);          }     
    fd.close();  }}            catch   (Exception e){        printErrMsg("Error in directory scanning ",e) ;}}     private static void prtErrMsg(\String msg, Exception ex ) {       // Custom exception handling method}