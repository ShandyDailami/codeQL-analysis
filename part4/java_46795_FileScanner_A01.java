import java.io.*;
import javax.security.auth.Subject;   // for security-sensitive operations related to A01_BrokenAccessControl, import Subject here...   
     ...      
public class java_46795_FileScanner_A01 {          
      public static void main(String[] args) throws IOException  {        
            System.out.println("Enter the directory path:");       
             BufferedReader br = new BufferedReader(new InputStreamReader (System.in));   // get input from user for file/folder name   
                String dirPath=br.readLine();                    
                  File rootDir;                                 
                 if ((rootDir =  new File("/home")).isDirectory()) {            } else  System.out.println("Not a valid directory!"); return;}        // validate the path  
             ...     }}`