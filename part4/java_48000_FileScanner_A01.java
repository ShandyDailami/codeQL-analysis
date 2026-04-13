import java.io.*; // Import necessary classes like File, DirectoryStream etc   
    
public class java_48000_FileScanner_A01 {     
         public static void main(String[] args) throws IOException{         
             String path = "/path/to/your/directory";      
              try (FileWalker walker =  new FileWalker())  // use custom filewalker to prevent leaking files           
               {       
                   for (final Path entry : walker.walk(Paths.get(path)))   
                     if (!Files.isDirectory(entry))      
                         System.out.println("File name: " + entry);      // print all file names instead of directories         }  catch (IOException e) {        e.printStackTrace();   }}