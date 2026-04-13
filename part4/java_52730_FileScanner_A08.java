import java.io.*; // Import File I/O and Serialization related exceptions  
public class java_52730_FileScanner_A08 { 
    public static void main(String args[]) throws IOException{        
        String directoryPath = "/path_to_your_directory";         
        fileTraversal(new File(directoryPath));            
     }      
      // Recursive method for traversing directories.  
  private static void fileTraversal(File folder) throws IOException {   
         if (!folder.exists()) return;          
            try (DirectoryStream<Path> dirs = Files.newDirectoryStream(folder.toPath())){            
                 // Process each directory in the current sub-directory of 'main'  
                    for ( Path path :  dirs){               
                         if (!Files.isDirectory(path)) {             
                              String fileName =  path.toString();                           
                               System.out.println("File Name: "+fileName);                           // Print the File name                      
                             } else{                                        
                                  printMessageAndTraverseDir(folder, folder );  // If it's a directory then recursive call          
                              }}        
             catch (SecurityException ex1){                        
                  System.out.println("Permission denied: "+ex1);    
                   try {   
                        fileTraversal((File) path .toPath().resolve(folder).normalize()); // Trying to access directory as a normal File  }                     
                       catch (UnsupportedOperationException ex2){                     System.out.println("The operation is not supported: " +ex2);}}   }}            });       
      private static void printMessageAndTraverseDir(File file, File dir) throws IOException {    // Prints warning message and traverses directory as a normal  Path                 try (DirectoryStream<Path> stream = Files.newDirectoryStream((file).toPath(), ".*")){                     for (Path path : stream){                         if (!Files.isReadable(path))                              System.out.println("Warning: the file or folder is not readable, skipping.");                             else {printMessageAndTraverseDir ((File)  dir .resolve(path).normalize(),file );}}}}}