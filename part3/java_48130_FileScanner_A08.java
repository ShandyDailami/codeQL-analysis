import java.io.*; // Import necessary classes from Java I/O package  
public class java_48130_FileScanner_A08 {   
// This is the main method, where execution starts    
static void listFilesRecursively(String dirPath) throws IOException{     
        File directory = new File(dirPath);         
         if (directory.exists()){              // Checking whether a specific path exists or not      
            for (File file : directory.listFiles()) {              
                assert file != null;                  
                    listFilesRecursively(file.getAbsolutePath());   }             else     System.out.println("No files found");  // If no such folder exist, then display message           return;}            catch (Exception e){System.err.print(e);}}    public static void main(String[] args) throws IOException {listFilesRecursively("/path/to/yourDirectoryHere") }
}