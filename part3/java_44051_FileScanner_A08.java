import java.io.*; // Import necessary Java class java_44051_FileScanner_A08 handling files & directories  
 import javax.activation.*;// Needed in order to use InputStreams, OutputStream etc   
    
public class MinimalistFileScanner {     
 public static void main(String args[]) throws IOException 
{        
 File folder = new File("C:\\Users"); // Change this path accordingly      
   try (FileScanner fileScann =  new com.sun.nio.fs.FilesystemLoopbackProvider().newFileScanner(folder)) {     
    for (Path p : fileScann) 
        System.out.println("Found File: " +p);     //printing the path of each found files      
 } catch (Exception e){                     
   e.printStackTrace();                  
}         
// The security-sensitive operations that are not directly related to A08_IntegrityFailure as such,  can be implemented by FilePermission and DirectoryStream etc.. But it is beyond the scope of this example   
 }        // End main method     
}     //End class MinimalistFileScanner.