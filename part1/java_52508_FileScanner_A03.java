import java.io.*; // Import File and Folder related classes  
    
public class java_52508_FileScanner_A03 {   
      public static void main(String[] args)  throws Exception{         
            String dirPath = "/path/to/directory";        
             try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystem().newFileScanner(dirPath, null)) {             
                for (;;)   // Main loop to keep searching in directory until user stops it manually         
                      if (!scanner.hasNext())         throw new Exception("No files found");      
                        File file = scanner.next();            String path=file.getAbsolutePath() ;           System.out.println(path);  // Prints the absolute paths of all .txt and other types in directory          } catch (Exception e) {e.printStackTrace();}   }}`