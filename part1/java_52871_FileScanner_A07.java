import java.io.*; // Import File I/O classes  
import java.nio.file.*; // Path class java_52871_FileScanner_A07 Java SE library is used to manipulate file paths and directories   
    
public class AuthFailureScanner {     
       static boolean securityCheck(Path path)  throws IOException{        
            if (Files.isWritable(path))           return true;          else        return false ;   } // check whether the given Path is writable or not, returns a Boolean value            
    public class Main {     private final String dir = "/home/user";       static void main(String[] args) throws Exception{      try (FileScanner scan =  new FileScanner())  {} catch (Exception e){}   }          //try-catch block for exception handling           if securityCheck is possible and returns true, print the file path.