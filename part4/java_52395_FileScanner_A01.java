import java.io.*; // Import the necessary classes 
  
public class java_52395_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{     
        String directoryPath = "/path/to/directory";      
         
         /* Using try-with resources for automatic closing of stream */          
         try (DirectoryStream<File> files =  Files.newDirectoryStream(Paths.get(directoryPath))) {  // Creates a Directory Stream to read all the subfiles in directory  
              System.out.println("Content inside " + directoryPath);      
               for (File file : files) {        /* Loop over each File */   
                   if (!file.isDirectory())     /* If it is not an folder, list its name and size*/     
                       printInfo(file);  // Use of a utility method to get the information about this particular object        
               }       System.out.println("End");          return;           }} catch (InvalidPathException e) {  
    /* Exception handling for invalid path */              logger .error ("Error occurred ",e );}}};