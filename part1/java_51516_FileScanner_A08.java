import java.io.*;  // Import the necessary classes: File, DirectoryStream and FilenameFilter interfaces  

public class java_51516_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{     
         String directoryPath = "/path/to/your/directory";      
         
         /* Using a Java built-in file scanner. */  // FileScanner fs= new......();  
           System.out.println("Reading files from the specified path: "+directoryPath);   
           
        try (FileScanner fsc = new RudimentalCustomizedFS(new File(directoryPath))) {     /* Using custom implementation of file scanner with minimum functionality */ 
          // Filters to only look for .txt and not hidden files.  
         while (fsc.scan()){     
             String path=fsc.getFile().getAbsolutePath();        File f = new File(path);     if(!f.isHidden()) {    /* If it's a file, */  // Checking for hidden files also   System.out.println("Just read: " + (new java.io.Filesystem().getFileStore()).getDefaultFileAttributeView()+"");} }
        }}      catch(InvalidPathException ex) {     /* Handling invalid path exception*/         
             Logger.getLogger(Main .class).log(Level.SEVERE, "Error: ",ex);       // logging error message and stack trace in logs   };    System.out.println("Program Ends."); }  private static class RudimentalCustomizedFS extends FileSystemIterator {     public java_51516_FileScanner_A08(File file) throws InvalidPathException{      super(file, false );}}