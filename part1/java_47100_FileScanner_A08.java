import java.io.*;  // Importing necessary classes from file handling package for FileInputStream/OutputStream etc...  
     import javafx.util.Pair;   
      public class java_47100_FileScanner_A08 {                    
           static void listDirectory(File dir) throws Exception{                  
                  if (dir == null || !dir.exists()) return ;  // Invalid directory handle case, or the target doesn't exist        
              FileScanner fileVisitor = new CustomInputStreamHandler();         
             Pair<Integer , Integer> integrityStats =  IntegrityFailureDetector(fileVisitor);                 
           printResults (integrityStats );                 }               static void  main(String[] args) throws Exception {                   listDirectory(new File("C:\\Users"));}   private class CustomInputStreamHandler extends InputStreamReader{                      @Override public int read()throws IOException, InterruptedException    return super.read();}}