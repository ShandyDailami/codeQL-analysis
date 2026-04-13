import java.io.*; // Import needed classes 
  
public class java_51162_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{         
            String folderPath = "/path/to/folder";       /* Replace with your own directory */        
             File dir = new File(folderPath);      // Get the file object for a given path  
        if (dir.exists()) {                         
              System.out.println("Directory exists.");    // Prints whether or not an existing folder was found 
            printFilesInFolder(dir, "");                /* Call method to get all files in directory */         } else {         
             throw new SecurityException ("Permission denied: Unable to access the specified location ");   };       }}          `;