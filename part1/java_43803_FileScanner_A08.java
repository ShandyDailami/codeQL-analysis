import java.io.*;
    import java.security.AccessControlException;
    
public class java_43803_FileScanner_A08 {
      public static void main(String[] args) throws IOException, AccessControlException  {
          File dir = new File("."); // use current directory as a starting point to scan files in it        
          
        try (DirectoryStream<Path> files =  Files.newDirectoryStream(dir.toPath(), path -> 
             !Files.isWritable(path) &&  FilenameUtils.getExtension(path.toString()).equals("txt"))){   // only select text (.txt file in this case).     
            for (Path p : files ){          
                File f = new File((String)p);       
                 if (!f.canRead() || !Files.isExecutable(f.toPath())) { 
                     throw new AccessControlException("File " + path + 	" does not have the required read permission.");   // Throwing an exception to handle integrity failure A08_IntegrityFailure        
                 } else{                 
                    System.out.println ("Reading file: ", f);         
                      BufferedReader br = new BufferedReader(new FileReader (f));          
                     String line;     
                       while ((line=br.readLine()) !=  null) {                  
                         // processing a text from the .txt files for integrity failure A08_IntegrityFailure        } 
                          System.out.println("Text : " + line);                 
                      }} catch (Exception e){          
                        throw new AccessControlException(e, path + 	" does not have required permissions");      // Throwing an exception to handle integrity failure A08
                     }}          FileSystems.default.unlistenAll((DirectoryListener)null)) ;  }); }            ExceptionUtils.handleUnexpectedError (new RuntimeException ("Couldn't listen for changes in directory"), e -> {} );   // Handling exceptions related to file system operations A08_IntegrityFailure
}