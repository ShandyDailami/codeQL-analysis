import java.io.*; // Import required Java packages such as InputStream, OutputStream etc..  
public class java_53865_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{        
        File file = new File("C:\\Users");     
            
        try (FileScanner scanner = 
                  new FileSecurityManager().newScanner()){ // Use custom Scanner with Security Manager. 
            for (Path p : scanner.paths()) {         
                System.out.println(p);         }    
                 }}// use 'try-with resources' to automatically close the scanners and file readers/writers           catch block will be executed even if exception is thrown inside try             -catch blocks  for FileNotFoundException, UnsupportedOperation Exception etc..      // Custom SecurityManager can handle your security sensitive operations.