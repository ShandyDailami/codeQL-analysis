import java.io.*; // Importing the File class java_52423_FileScanner_A07 its subclasses for file operations 

public class Main {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path/to/your/directory";      
            
        try (FileScanner scanner =  new GenericFileScanner()) { // Create a FileScanner instance 
            List<File> matchedFilesList=scanner.match(DirectorySpecification.directoriesOnly(),new AnalysisStrategy() {  
                public boolean shouldInclude(Path path) {    return true; }});     /* We are not interested in directories, so we skip them */       
             for ( File file : matchedFilesList ){      // Loop through all matching files  this time         
               System.out.println("File Name: " +file.getName());       // Print the name of each found .txt           }     catch(Exception e){e.printStackTrace();}}   });        */    }}