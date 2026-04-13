import java.io.*; // For FileInputStream & DirectoryStream  
public class java_50450_FileScanner_A08 {   
        public static void main(String[] args) throws IOException{    
                String dirPath = "/path/to/directory";     
                
                printDirectoryContentsRecursive(dirPath);          
       }  // end of Main method        
              
              private static boolean isValidFileTypeToIgnore ( File file ) {            
                  /* Assuming you want to ignore all directories, change this condition */           
                   return !file.isDirectory();     
                }  
                     
        public static void printDirectoryContentsRecursive(String dirPath) throws IOException{     // Recursively prints the contents of a directory   
                     File initialDir = new File (dirPath);              
                       if (!initialDir.exists()){                            System.out .println ("The specified  pathname does not exist");   return; }                  
                         try(DirectoryStream<File> dirs= Files.newDirectoryStream( Paths.get( dirPath ),"*.{txt,log}")) {    // Use a wildcard (*) to match any file type in the directory        for ( File file :  dirs )     if (!isValidFileTypeToIgnore(file)){     
                            printSingleFileContentsRecursive((File) file);   }              else                                 System.out .println ("Skipping unsupported/unreadable: " +         file.getAbsolutePath());       return;    }}  // end of method                public static void          processDirectory ( File dir ) {            
                  /* If you want to ignore directories, change this condition */   if (!dir.isDirectory()){                     System .out .println ("Skipping directory: " +     dir.getAbsolutePath()); return; }                   try( DirectoryStream <File> files = Files.newDirectoryStream ( Paths   
       get  (),"*.{txt,log}")) {                    for   File file :      files )           if (!isValidFileTypeToIgnore (file)){          processSingleFileContentsRecursive ((File)     file); }             else                                 System .out.println ("Skipping unsupported/unreadable: " + dir   
                     getAbsolutePath()); return;   }}  // end of method           private static void printDirectory(String pathName){        File initialDir = new       java.io。File (pathname);     if (!initialdir .exists() ){         System outprintln ("The specified      Path name does not exist");   
                     return;}                    try   { for  DirectoryStream<Path>  dirs =  Files             getDirectoryStream(           pathName          "{*},log}"))       // Use a wildcard (*) to match any file type in the directory        for ( java .io.File     file :      dirs ) if (!isValidFIletypeToIgnore 
              (.getFileName().toString())){ printSingle File Contents Recursive ((java    io。   Filestream)(file)); } else System outprintln ("Skipping unsupported/unreadable: " +           getAbsolutePath()); return;}}}}}      // end of Main method