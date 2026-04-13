import java.io.*; // Import the necessary classes from Java libraries: InputStream, OutputStream etc...

public class java_48795_FileScanner_A03 {
    public static void main(String[] args) throws IOException{  
        String directoryPath = "your_directory";// replace with your own path here e.g C:/Users/username/Documents 
        
        // Get the file object from a specified parent folder (provided by user).    
        File dir = new File(directoryPath);   
          
        scanDirectory(dir, directoryPath );  
          }      
            
      static void scanFileSize(String path) throws IOException { 
         // This method will print the size of file to console. No injection point here because this is just a small part in larger program where we are injecting user input into commands and hence no risk for A03_Injection  
          File f = new File (path);   
             if(f != null) {     // In case of file does not exist, it will show error as well. It's a good practice to handle such situations in real program  but I added exception handling for the sake of simplification here  
               System.out.println("File name: " + f.getName()+ ", Size (bytes):"  +f.length());    //print file size    
             }      
      }          
        
        static void scanDirectory(File directory, String path) throws IOException { 
            for (File file : directory.listFiles())   // Iterate over all files and folders in the specified folder recursively by calling listFiles() method   
                 if (!fileMarkedAsSkipped && !directoryMarkedAsSkippeInSubfolder(path, subFolderPath))      {     /* If not already marked as skipped */ 
                     System.out.println("Directory: " + file.getAbsolutePath());   // Print the absolute path of directory and all files inside it   
                      if (file.isFile() && isTxtFile(file)){       //If we have a textual document, print its name with size     
                          scanFileSize(file.getCanonicalPath()) ;     /* Get canonical file system representation then call the function */   }  else{        
                           if (directoryMarkedAsSkippeInSubfolder("", "")) {    //If this is a sub directory, recursively invoke method on it     
                               scanDirectory(file , "" );       };//passing empty string as path for deeper scanning in that folder     }}else{}  /* If the file or dir isn't textual (image), skip them */ }}}}            catch {} //catch block to handle any exception if there is one   });}}