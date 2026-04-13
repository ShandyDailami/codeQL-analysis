import java.io.*; // Import necessary classes such as File, FilenameFilter etc..  
public class java_45739_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{         
         String directoryPath = "/path/to/your/directory";  /* your path here */       
          
         // Use a file filter to only scan .txt files.     
         File folder = new File(directoryPath);      
         FileScanner fs = new FileScanner();    
         
         if (folder.exists()){            
               for (File f : folder.listFiles((dir, name) -> {            // Use a method reference to check file type          
                   return name.endsWith(".txt");}))   {        /* Set your criteria here */ 
                    System.out.println("Found .txt File: " +f);       }    
         }else{         
             throw new IllegalArgumentException(directoryPath+" does not exist or it is not a directory.");      // Check and handle if path was incorrect  
        }}          
}    private static class FileScanner {            void scanFile (String fileName) throws IOException {}  /* This function should contain your security sensitive operations */ }