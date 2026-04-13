import java.io.*;   // Import File and IO exceptions    
public class java_44004_FileScanner_A07 {      
    public static void main(String[] args) throws IOException{         
        String directory = "/path/to/directory";     
        
        try (FileScanner scanner = new FileVisitWrapper().fileScannable();){  // Using an interface for file visiting             
            Files.walkFileTree(Paths.get(directory), scanner);          
             printFilesFoundInDirectory(scanner, directory + "/");         
        } catch (Exception e) {              
         System.out.println("An error occurred while scanning files: "+e.getMessage());      // Error handling           
       } 
    }}// End of Main class