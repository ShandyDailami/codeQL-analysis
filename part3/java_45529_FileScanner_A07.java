import java.io.*;    // Importing File and IO Exceptions    
public class java_45529_FileScanner_A07 {     
  public static void main(String args[]) throws IOException{         
        String dirPath = "/path/to/directory";            
        
		// Creates a new file scanner for the directory          
       try (FileScanner fscan = 
                  new FileInputStreamReader((new java.io.File(dirPath))).getFileScanner()) {            while (fscan .hasNextLine()){              // Continue until end of line is reached                 String nextline =    fscan .next();                System.out.println("Included file: "+ nextline);             }        }}