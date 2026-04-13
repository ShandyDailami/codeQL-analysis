import java.io.*; // for File, Files and Paths exception handling classes  
import static java.nio.file.StandardCopies.* ; 
// Import other necessary imports here if needed by your task or program requirements like Scanner etc...   
    
public class java_52237_FileScanner_A03 {     
        public static void main(String[] args) throws Exception{             //Main function        
            File file = new File("src");          // Specify the directory to be scanned 
                                                    // Change "C:/Users/Username" according to your needs.   
           try (FileScanner fscan =  new com.sun.nio.fs.UnixFileSystem().newFileScanner(file, true)) {     
            while (fscan.hasNext()) {         // Main loop for reading files      
                File fileToRead = fscan.nextPath();  /* Returns the next file from directory to be read */   
               System.out.println("Found text file: " +fileToRead);  
             }           
           } catch (Exception e) {         // Catch block for handling exceptions      
              System.err.println(e.getClass().getName()+" : "+e.getMessage());         
               throw new Exception();  /* Re-throw the exception */   
        }}   });