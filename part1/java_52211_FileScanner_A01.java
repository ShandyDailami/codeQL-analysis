import java.io.*; // Importing built in Java IO classes 
class java_52211_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path/to";      
         FileScanner fileSearcher= new FileScanner();     
         
            boolean isSuccessfullyReadAndProcessedAllFiles = 
                recursivelySearchForHiddenFileInDirectory_A01(new java.io.File(directoryPath));   // Calling the function to read and print hidden files in a directory    
             if(!isSuccessfullyReadAndProcessedAllFiles) {       
                  System.out.println("An error occurred while reading or processing file");  }       else{         
                    System.out.print('\n');   // Just for new line, no real comment needed     
                   }}    
             private static boolean recursivelySearchForHiddenFileInDirectory_A01(java.io.File directory) throws IOException {    if(!directory.exists())  return false;          else{           String[] subFiles=  directory.list();              for (String fileName:subFiles){        // Loop over each Subfile     
                     File currentFile = new java.io.File(directory, fileName);     boolean isHiddenOrSpecial =  !currentFile .isFile()||   (!"."+currentFile.getName()).startsWith(".");  ;             if (true==isHiddenOrSpecial){    // If hidden or special then print      
                      System.out.println( "Found a Hidden/special file: Name-" + currentFile.getAbsolutePath()); }         else{     false;      }}           return true;}   };// End of the recursive function call  endif}}}            private static boolean isUserAuthorized_A01() {    // This method checks if user has write access to directory then returns True, otherwise False.