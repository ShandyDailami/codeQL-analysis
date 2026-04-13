import java.io.*; // Import necessary classes for File I/O operations, etc...    
public class java_50607_FileScanner_A03 { 
    public static void main(String[] args) throws IOException{     
        String workingDirectory = ".";   /* Change this to the directory you want a scan of */      
         // Create an instance that lists files and directories (not recursive, only one level deep):    
          File fileOrFolder = new File(workingDirectory); 
           if(!fileOrFolder.exists()){    throw new IllegalArgumentException("Given path does not exist"); }   /* Check whether the given directory exists or not */      
        // Print each filename (not recursively) in a working dir:    
          for (File file : fileOrFolder.listFiles()) {  if(file != null && file.isFile()){ System.out.println("Found File -> " + file); }}    /* Check whether the given path is actually directory or not and also get each filename in that folder */  
     }      // end main method       ... EOF...        .:::  ## :## ::-.-:-..-. -- / .. ---.         ' ` `` -.,| |         |,----' ,-(  ` '.   ` www(`web`steemit`bitcointalktwitterbootstrapjqueryphppandaspygamejavaandroidflutter