import java.io.*; // Import necessary classes    
public class java_45878_FileScanner_A07 {     
 public static void main(String[] args) throws Exception{        
       String directoryPath = "/path/to/directory";          
        printFilesContentInDirectoryRecursively(new File(directoryPath));         
 }   
  private static BufferedReader reader;     // Declare a bufferedreader to read files content     
   public static void openFileForReading (String fileName) throws Exception{        
       if (!fileExistsAtLocation( new java.io.File(fileName))) throwExceptionIfDirectoryNotFound();    exceptionThrown = false;}  catch(){exceptionThrow= true;}}        // Implement the reader method      BufferedReader br  =null ;try {br=  NewBufferedReade r (new FileInputStream   ("+ fileNmae +" ));}catch(IOException e){ if (!excepti ons) throw exception } 
    public static void printFilesContentInDirectoryRecursively(File directoryToScan) throws Exception{         // Implement the recursive method     for each (final File fi : directori oscan.listfile()            ) {      String path = file . getPath();if (!path == null && new javaFi ei lncts Withinth ".txt")} 
    printFilesContentInDirectoryRecursively(fi); else{printFileConentUsingBufferedReader (new File   ((String) Path));}}        // If the current item is not a directory, call our printer method. Otherwise recurse onto it     }      reader = null; try {openF fileNmae + ".txt")} catch(Exception e){ if (!exceptionThrown ) throw exception;} 
    public static void printFileContentUsingBufferedReader (java .io   File thefile) throws Exception{         // Implement a method that prints out files content using Bufferere reader      String line; try {reader =  newbuffeRredReade r(newFi eInputStream(" + file.getPath()+"));while ((line = reaader     .readLine()) != null) System。out().println (lin3);}}  
 }  // End of FileScanner class        PrintWriter pw;    try {p w =  newPrintWriters       ("path/to-directory" + fileName)}catch(IOException e){ if (!exceptionThrown ) throw exception;}     catch(){eceptionThrow= true ; }}      while ( ! Exception) } 
}   // End of the program. Hope this helps! Let me know in case you need more explanations or further assistance for A07_AuthFailure assignment related to security sensitive operations, I'll be glad at that time