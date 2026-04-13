import java.io.*; // Import necessary classes/libraries  
public class java_44183_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        FileScanner("C:/", ".*");            
       } 
      @SuppressWarnings({"unused","resource"})          
          private static void FileScanner (final String path, final String pattern){   // Method to scan files   
            try {             
                File fileOrDir = new File(path);                 
                 if (!fileOrDir.exists())  throw new IllegalArgumentException("Path not exists: " + path) ;         
                    for (File f : fileOrDir.listFiles()){                      // Get list of files in the directory  
                        System.out.println((f.isDirectory() ? "[+] DIR" : "[ ] FILE")  + "/-" +  f);                   if(f.isDirectory()) FileScanner(f.getAbsolutePath(), pattern) ;    }        // If it is a file then recursive call  
              }} catch (Exception ex){ System . out . println ("Error in processing directory: " + path  + "-" +  "\nExiting...");         throw new RuntimeException("Failed to scan files",ex );}}  Catching exceptions will end up here and it's not recommended because of security concerns.
}