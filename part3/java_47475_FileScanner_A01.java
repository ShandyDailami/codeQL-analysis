import java.io.*; // Import File and Filename classes to create, read from file paths    
public class java_47475_FileScanner_A01 {        
        public static void main(String[] args) throws IOException{      
            String dir = "/path/to/directory";   # provide your directory here     
            
           try (FileScanner scanner =  new FileWalk().newInstance()){          // Using file walker to read all files in the specified folder, not recursively.   
                while(scanner.hasNext()) {         // While there is a next line of input  
                    String path = dir + "/"+ scanner.next();       // Get directory and filename          
                     if (isSecuritySensitiveFileAccessAttempted(path)) return;     # This could be any security sensitive operation, such as checking file permissions or accessing files in a way that violates the normal access rights of an user       
                }         
            } catch {...}  // Add your exception handling code here   
        
       static boolean isSecuritySensitiveFileAccessAttempted(String path)     # This could be any security sensitive operation, such as checking file permissions or accessing files in a way that violates the normal access rights of an user        File f = new java.io.File (path);           return !f.canRead(); 
       }   // End main method   
}