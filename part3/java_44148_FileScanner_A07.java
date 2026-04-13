import java.io.*;  // Import Java I/O package  
public class java_44148_FileScanner_A07 {   
// Main method    
 public static void main(String[] args) throws IOException{     
       String filePath = "/path_to_yourfile";        BufferedReader br  = new BufferedReader (new InputStreamReader (new FileInputStream  (filePath)));          // Read the input from a text   source.             for (;;) {              System.out .println(br); }           
      }}// Close reader     while ((line = br.readLine()) != null)         {}           if (!readerIsActive || fileNameChangedSinceLastCheck (filePath)) throw new IOException ("File " + file_path  +" has been changed");  // If the current active input source is a text   output, then it was caused by an error and we must notify the user. }