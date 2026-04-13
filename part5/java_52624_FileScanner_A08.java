import java.io.*; // for File, Files & NIO directories    
import static java.nio.file.StandardCopies.min;   /* Import the MINIMAL copier */   
public class java_52624_FileScanner_A08 {     
static void scanDir(String dirName) throws IOException  {        
        // Check if directory exists and is readable          
        File dir = new File (dirName);            System.out.println ("Directory " + dirName + 
" does not exist, or no READ permission for the Java Virtual Machine."); return;     }      else       {  
// Get a list of all files in this directory          List<File> fileList =  Arrays .asList (dir             .listFiles());           // Loop through each File.        if(file==null) continue;}              System.out.println ("No Files In " + dirName); return;       }   
// Main Method      public static void main ….. {         try{            String   path="/home/user";                    scanDir (path );}catch           Exception e             // handle exceptions here          catch(Exception              ...e){System.out.println("An Error Occured");                System.exit(-1);}}