import java.io.*; // Import File I/O classes 

public class java_49006_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{     
        String directoryPath = "/path_to_directory";     // Adjust this to your specific folder's path      
        
        try (FileScanner fileScouter= new File(directoryPath)) 
        {  
            int totalFiles = 0;   
             while(fileScouter.next())     
             {         
                String absolutePath = fileScouter .getAbsolutepath();       // Gets the full path of each found files    
                  System.out.println("File Found: " + absolutePath);        // Logs a message with filename    ))   println (String s) prints to console and auto linebreak for multiline statements, same as return;      }          fileScouter .stopSearch();           if(totalFiles > 0 ){System.out.println("Total Files: " + totalFiles);}        
             }}    catch  (InvalidPathException e){   // Catching the exception when path is invalid     System out println ("Directory not found"); }      finally {          File file = new java .io .file(directorypath) ; if(!filescouter.isDirectory()...and so forth, for all possible exceptions and use-cases