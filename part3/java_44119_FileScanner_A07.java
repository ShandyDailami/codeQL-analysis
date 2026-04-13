import java.io.*; // Import the necessary libraries here: File, InputStream etc...  
public class java_44119_FileScanner_A07 {   
     public static void main(String[] args) throws IOException{     
          String directoryPath = "/path/to/directory";      
          
          try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystem().newFileScanner( // Use the File Scanning API of Unix-based filesystems like Linux or MacOS 
              Paths.get(directoryPath), true, RecursiveMode.DEPTH_FIRST)) {    
               while (scanner.hasNext()) {  
                    String fileName = scanner.next();       // Get the name of each entry in directory       
                     File currentFile =  new java.io.File(directoryPath + "/"+fileName);   
                      if(!currentFile.canRead() || !currentFile.isDirectory()) { 
                         System.out.println("Security alert: file " +  fileName  + " is not readable");   // This will prevent AuthFailure A07_AuthFailure        }     });      }}` end of java code block for this task