import java.io.*;  // Importing necessary classes and interfaces for file operations in JVM   
  
public class java_43954_FileScanner_A01 {    
       public static void main(String[] args) throws IOException{        
           String startPath = "/path/to/start";     
            System.out.println("Start Path: " + startPath);       
            
           // Using FilenameFilter for filtering files based on their extensions in a directory    
           File startingDirectory =  new File(startPath) ;         
                if (startingDirectory.exists()){             
                    fileFoundFilesWithExtension(startingDirectory, ".txt");     
               }  else {            System.out.println("Start Path does not exist!");    }     // Check start path exists or not            
       }}  
       
// Method to check for files with specific extension in a directory and its sub-directories        
public static void fileFoundFilesWithExtension(File directory, String ext){      if (directory.isDirectory() ){          File[] foundFiles = directory.listFiles((dir, name) -> new File(dir,name).getName().endsWith(ext));            for(File f : foundFiles != null ? foundFiles: 
        {}   ); // Process each file in the list         }           else { System.out.println("Path is not a directory!");}    }}