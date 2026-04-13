import java.io.*; // Import necessary classes -------------------------------------------
  
public class java_50983_FileScanner_A07 {    
    public static void main(String[] args) throws IOException, FilePermissionDeniedException{      
        String directoryPath = ".";         // Set your target path here           
          
        if (args != null && args.length > 0){            
          try { 
              DirectoryStream<File> stream =  Files.newDirectoryStream( Paths.get((directoryPath)) );   
               for ( File file : stream) {                    
                  System.out.println("Reading: " +file);       // Uncomment this line to enable logging                                 
                   readFilesRecursive(file, true /*print*/);   // Use recursion if you want more details         
                } 
           } catch (FileNotFoundException e) {    
               System.out.println("No such directory: " +directoryPath );     
            return;                                                
        }} else{                  
              Files.newDirectoryStream( Paths.get((System.getProperty("user.dir"))),".").forEach(Main::readFilesRecursive);   // Scan current dir if no args provided                     }  catch (IOException e) {     println ("Cannot read the directory: " +directoryPath,e ); return;}