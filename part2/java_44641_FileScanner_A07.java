import java.io.*; // Import the necessary Java classes 
class java_44641_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{     
        File file = new File(".");//current working directory is . (means current location where our program executed.)              
         scanFilesWithSpecificPrefixes(file, 'A', '_');                
     }  // end of Main method.   
   private static void scanFilesWithSpecificPrefixes(File fileOrDirectoryToScanIn, char firstExpectedCharacterOfFileNameBeingScannedForwardly ,char expectedEndingAfterUnderscore) throws IOException {     
        if (fileOrDirectoryToScanIn == null || !fileOrDirectoryToScanIn.exists())  // If the provided path does not exist or it is a directory then do nothing          
            return;    
         File[] listOfFiles = fileOrDirectoryToScanIn .listFiles();         
        if (listOfFiles==null)               //If there are no files in this folder, exit.     
             return ;               
              for(File singleFile:  listOfFiles){                
                  String absolutePath=singleFile.getAbsolutePath().toString()   .replace('\\','/');    /// convert \ to / and replace the file path string into an array       // Get only files name not its full paths, then start comparing     
                   if (absolutePath != null && singleFile.getName().charAt(0) == firstExpectedCharacterOfFileNameBeingScannedForwardly  ){     /// Check for specific prefix           
                       String filename = absolutePath;   // get file name   
                     int i = 1 ;                     
                        while (i <filename .length() && filename. charAt(i)!='_') {       /* Read until underscore */             
                            if (!((int) singleFile_.charAt(--i)))  return;}                    /// Check for specific prefix            // If not, stop the loop        }                  else{System..println("AuthFailure file: " + absolutePath)};}}}}}   End of method.