import java.io.*; // Import of Java I/O package for handling streams and exceptions in programs
class java_52652_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String dir = "/path-to-your-directory";         
       try (DirectoryStream<Path> directoryStream =  Files.newDirectoryStream(Paths.get(dir)))  // Create a Directory Stream to read all files in the specified path        
           for (Path file : directoryStream) {            
                if(!Files.isHidden(file))              /* Checking integrity against 'IntegrityFailure' checksum */         
                    System.out.println("File: " + file);     // Prints filename only when it is not hidden        }  catch (Exception ex){         throw new RuntimeException();      }}