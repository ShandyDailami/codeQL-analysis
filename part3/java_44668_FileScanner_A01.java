import java.io.*; // for File, etc., 
// import other necessary libraries here if needed e.g: ioi maths...  
public class java_44668_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
           String path = "/path/to/directory";      
            walkDirAndPrintPermissionsForFilesInDirectory("/", new FileInputStreamReader(), 2);         // Use your input stream reader for real use.        }   private int currentAccessLevel;     static final AccessRight READ_ACCESS = 0b1 ;      ... and so on    (more access rights here)
            defender(new PrintWriter("logfilepath"), new FileInputStreamReader());  // Provide your log file path for real use.          }   private void walkDirAndPrintPermissionsForFilesInDirectory... }}`;     public static final int READ_ACCESS = 1 <<0 ;// permission to read a directory/entry */