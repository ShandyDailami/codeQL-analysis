import java.io.*;  // Importing file handling classes  
public class java_47474_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{     
         String directoryPath = "/path/to/directory";       
         ScanFilesInDirectory(new File(directoryPath));      
     }         
          
  // Recursive method to scan files in a given file path.  
  private static void ScanFilesInDirectory (File dir) throws IOException {     
    for (File file : dir.listFiles()) {         if (!file.isHidden() && !"..".equals(file.getName())){            // Only allow non-hidden files and not "." or parent directory             FileScanner fs = new FileScanner();                String[] wordsToFind= {"keyword1", “word2”, ....};               if (fs.CheckIfFileContainsWords(new FileReader(file),wordsToFind)){                 System.out.println("The file: " + dir + "/"+  
   > file.getName() +  ", contains the required words.");}} else {                // Else we only print .jar files            if (dir.isDirectory())          ScanFilesInDirectory(new File("/path/to/" 目录  +file));}}}else{                  System.out.println("The non-java file: " + dir+ 
   /"+    filename);}}} }