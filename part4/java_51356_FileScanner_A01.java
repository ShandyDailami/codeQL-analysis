import java.io.*; // Import necessary class java_51356_FileScanner_A01/InputStream to read file 
                   // import FileNotFoundException / DirectoryIterator for traversing directories  
public class Main {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path-to-your-directory";     
               /* Replace '/' with '\' on Windows system, or replace it by your desired path */ 
           File initialDirectory =  new java.io.File (directoryPath);   //Create a file object to refer the main folder/file   
        scanFiles(initialDirectory );     // Calling method for scanning files and sub-directories        
      }         
       private static void printUsageAndExit() {             System.out.println("USAGE: Main <directoryPath>");  exit(-1);   }}             
            public class FileScannerException extends Exception{        /** Constructs a new exception with the specified detail message */    protected Main(String msg){         super (msg)};}}