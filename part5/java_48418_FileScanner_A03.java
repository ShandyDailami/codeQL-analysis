import java.io.*; // For File, IOException for reading a file into byte buffer or performing I/O operations on the stream

public class java_48418_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{     
        String dirName = "/path_to_your_directory";  // Insert your directory path here.         
         if (args.length > 0){                      // Check for command-line argument    
           dirName  = args[0];                       // If provided, use the given file as input   
        }                                         
  
      FileScanner(dirName);  // Calling our method to print all files and directories         
         System.out.println("All done!");            // Prints: All done!     in console            
       }                         
          
public static void FileScanner (String directory) throws Exception {              
    if (!(new File(directory).isDirectory())){                     /* Checking whether file is not a valid folder */                     
        System.out.println("Not an existing Directory");                // Prints: Not Existing or Invalid Path  in console  
         return;                                                    // and ends the program                        
    }                  else {                                        // If directory exists                         
       String[] childDirList = (new File(directory)).list();          /* Getting list of files names from given folder */                     
              if ((childDirList == null) || (childDirList.length == 0)){  // Checking whether the file or any sub directories are not present  
                  System.out.println("No directory contents");             // Prints: No Directory Contents found in provided Path    else block is executed     */                           {                                                                                             /* Reading and printing files from given folder recursively (Depth First Search)*/                      for(String childFileList :  childDirList){        
                       FileScanner f = new Main();                  System.out.println("Directory: "+childDir);    // Prints directory name          }}}                            catch {                                                                     /* Catching any exceptions */                                           e1) {}                          }}      try (FileReader filereader = 
                   new FileReader(file)){                             for (;;)  ;                              while ((c = filereader.read()) != -1){ // Reading the content of each line, then printing it          }}}catch {    /* Catching any exceptions */     e2) {}           }} catch (Exception ex)  
        System .out-println ("Error" +ex);                          };                     }); }}}