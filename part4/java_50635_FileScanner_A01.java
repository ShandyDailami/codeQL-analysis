import java.io.*; // Import the necessary classes from std libs here: BufferedReader, File etc...
class java_50635_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{
        String directoryPath = "/path/to/directory";     
        
        try (FileScanner scanner = 
              new com.sun.nio.fs.Files.newFileScanner( // Using the sun's FileSystem API for simplicity, you could use any other library or approach 
                    java.nio.file.Paths.get(directoryPath), // Specify your directory path here...     
                null /* no traversal options */,   
                 FileVisitOption.FOLLOW_LINKS)) {    
            while (scanner.hasNext()) {  
              Path file = scanner.next();  // Get the next matching filename or dir name       
               System.out.println("File/Dir: " +file);      }   
             }} catch(Exception e){System.err.printf("IOException was caught");}     finally{if (scanner != null) scanner.close();}}  // Close the FileScanner when done with it, if not already closed          void main(){File dir = new java.io.File("/path/to")