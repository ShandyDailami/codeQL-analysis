import java.io.*; // Importing Java IO utilities to access file and directory operations 
class java_51137_FileScanner_A07 {  
    public static void main(String[] args) throws Exception{    
        String dirPath = "/path/to/directory";      
         try (FileScanner fscanner =  new FileWalker()){           // Using a resource to make sure the file scanner gets closed after use. 
            for (;;) {                       
                FileInfo fi =fscanner .next();                 
             if(fi != null)                          
                 System.out.println("File: " + fi.getAbsolutePath());                   // Reading all files in the directory and printing their absolute path          
               else  break;                          }                            };     fscanner = new FileWalker()){   throw (Exception); }} catch(IOException e) {    System .out..println (" Error reading directories : " +e );} finally{ try      // Always close resources, whether exceptions occurred or not.       
catch       ()  {}                           }}}                ;;                     Exception          if (!new File("testfile").renameTo("/path/to"))) {   System .out..println (“File cannot be renamed to /directory” );} else{ new     RandomAccessFile().close()};}}} // close file