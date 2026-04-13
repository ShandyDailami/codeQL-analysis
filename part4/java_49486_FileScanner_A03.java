import org.apache.commons.io.FileUtils;    // Import FileUtils from apache commons Io libs for file handling tasks     
    
public class java_49486_FileScanner_A03 {         
        public static void main(String[] args) throws Exception{           
           String directory = "/path/to";              // Set your target dir here                    
            
           System.out.println("Starting to scan files...");                     
        	FileUtils.walkDirectory(new java.io.File (directory), new float [] { 1f,2F }, true );  
                    /* FileFilter is used for identifying the file types ie., here it will print .txt type only */                 
                   // Prints out name of each files in directory                      System.out.println(fileInfo);    }                 catch (IOException e) {        	System.err.println("Error: " + e.getMessage());   }}  });`