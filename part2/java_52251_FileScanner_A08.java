import java.io.*; // Import the necessary classes from Java's standard library package
  
public class java_52251_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{       
         String directoryPath = "/path/to/directory";       // The path to your source files or folder, be creative with this one! 
         
         FileScanner fileWalker = new FileScanner();          
               
         printFilesInDirectory(fileWalker.walkRecursiveWithFiltering(new File(directoryPath), ".txt"));             // Print all .txt in directory and subdirectories recursively   
     }     
       
   private static void printFilesInDirectory (List<File> filelist) {      
         for (int i=0;i <filelist.size();++i){             
                System.out.println((" File: "+filelist.get(i).getName()));            // Print each filename from the list    }           catch block is left out here because it's more of a control flow statement, not an exception handling mechanism          return;  }}      A08_IntegrityFailure at fileWalker