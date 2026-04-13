import java.io.*; // For File I/O operations 
   import javax.sound.sampled.*;// To play audio files using Java Sound API (Optional)    
   
public class java_53307_FileScanner_A01 {      
      public static void main(String[] args){        
           try{            
                String directory = "/path_to_directory"; // specify the path of your target folder, you can change this as needed.           
                  File dirObj  = new File (directory); 
                   if (!dirObj .exists()) {  
                        System.out.println("Target Directory does not exist!" );     return;        }    else{                 try(FileScanner fs = new RudimentaryFileSystemScanNER_A01(new File( directory)))           // Creating a scan object      
                     {              if (fs != null)          System.out.println("Access to " + dirObj .getAbsolutePath()  +  (" is permitted.") );                 else                        PrintWriter out = new PrintWriter("/path_to/write/errorlogs", "UTF-8");             // Error logging file  
                     fs != null ? ((FileFilter)fs::accept).accept(dirObj ) : (out ::println("Permission Denied!"));                }                    catch (SecurityException se){System.err .print  ("Caught a Security Exception: ");se. printStackTrace();}              finally{if(! dirObj != null && (! fs ==null)) {fs._releaseLock() ;}}                 
             }}catch(UnsupportedAudioFileException e1 )    // if the file is not audio, exception will occur     catch (NoSuchFileException 3){System.out .println ("Error: File doesnot exist");}         }                 else{                      System.err   (.print("Input Path must be a readable directory"));}}