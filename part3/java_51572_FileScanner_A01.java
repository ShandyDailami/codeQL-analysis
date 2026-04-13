import java.io.*; // Import the necessary classes from file handling library
  
public class java_51572_FileScanner_A01 {    
    public static void main(String[] args){         
        String directoryPath = "C:\\path_to_directory";      
        
        try{            
            ScanFilesInDirectoryUsingFileAPI scanner =  new 
                    ScanFilesInDirectoryUsingFileAPI();                
                      
              System.out.println("List of files in the specified Directory are : \n" +         
                                  "----------------------------------------------------------------------------------------\n");               
               // List all file names (including their full paths) within a directory to File object array using recursive method 1     - DFS    [filePath]       
              String[] filenames = scanner.listFilesInDirectoryUsingFileAPI(directoryPath);  
                        for (String filename : filenames){               // For each file in the list          
                            System.out.println("Found File: " + filename );     }                    return;         }}          catch{  e-> {System . out - Println (. sr)} ;}}                   });      `