import java.io.*; // Import the necessary classes for handling files and directories: File, Paths etc...
class java_47896_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String directory = "/path/to/your/directory";      
        
        try (FileScanner scanner =  new com.sun.nio.file.Files)  // This is using the sun-based FileSystem API for convenience  
            {            
                file(scan,new java.nio.file.Paths( directory ),true , RecursiveMode.FILE_TRAVERSAL))          
                    .filterOut("txt")     # Filters out text files (assuming we want to exclude txt)    // Use filterOut if you only need a list of directories not the file names  
                      .map(file -> "'" + path2string(new java.nio.file.Paths((String )path().toString()))+"'")        # Convert Path into String for output      
                    (.forEach(System.out::println));     // This is where we print out the file names to console    }  catch (InvalidFileException e) {   throw new RuntimeException("Error:" +e);}      }}`;