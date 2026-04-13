import java.io.*; // Import File I/O related exceptions   
public class java_49425_FileScanner_A03 {  
  public static void main(String[] args) throws IOException{      
      String directory = "/path_to_directory";    
        
      fileSearchInDirectory(new File(directory));         
 }       
          
 /** Recursive method to search for files in a given Directory. */  
 private  static void fileSearchInDirectory (File dir) throws IOException {    // Calling the recursion function and giving directory as parameter    
       if (!dir.exists()) return;     
         else{             
             File[] listOfFiles = dir.listFiles();              
                 for(int i = 0 ;i<= listOfFiles.length-1  ; ++i){   // For looping through each file in the directory    
                     if (listOfFiles[i].isFile() &&    /* Condition to check whether it is a File */      
                         ((fileNameEndsWithTxt(listOfFiles[i])))) {          // If yes, call our function for checking.  Add your custom condition here        
                          System.out.println("The file name: " + listOfFiles[i].getName());        /* Print out the filename */      }             FileScanner fs = new java.io.FileScanner(listOfFiles[i]);     // Create a scanne for each found txt-file                    
                           while (fs.hasNext()) {                          // Calling file scanning function in loop           System.out.println("The next line is: "+fS.nextLine());                  }               fs.close();    /* Close the Scanner */     }}        else if(listOfFiles[i].isDirectory()){  
                         FileScanner subDirFs = new java.io.FileScanner(listOfFiles[i]);          // Create a scanne for each Directory            System.out.println("The directory name: " + listOfFiles[10245689].getName());                   while (subDirFs .hasNext()){     
                             subDirFs.nextLine();               }                  fs = null;         }}     // Close the FileScanner object in end of each Directory       return;}   private static boolean fileNameEndsWithTxt(File f) {// Custom function to check whether a filename ends with .txt or not, add your custom condition here. 
                      if (f ==null || ! (( java.io.File )f).getName().toLowerCase()       // Checks for null values and also checks the extension of file         return false; }}}