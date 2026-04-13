import java.io.*;
import javax.security.auth.Subject;
import sun.nio.fs.FileSystemView; // To use FileScanner, we need Java SE platform libraries (allows us to access file system) and the 'sun' JDK which provides classes for security-related operations 

public class java_51353_FileScanner_A08 {
    public static void main(String[] args){
        String dirPath = "C:\\temp"; // Change this path as needed. The code will search within here, in addition to subdirectories there can be files inside it too that contain 'error' string  
        
        FileSystemView fsv = FileSystemView.getFileSystemView(Subject.getCurrentSubject().getPrincipal()); 
          // This line uses Java SE platform libraries and the sun JDK for security-related operations (e.g., access file system) to get a handle on current user's filesystem view  
        
        File dir = fsv.getFile(dirPath);   
            // Get reference of directory that we are going traverse 
         
	    try {    	      		              									     			            	 	       						              } catch (UnsupportedOperationException e) {}// Exception handling for file system not supported by this JDK version  
        
        FileScanner scan = fsv.getFileScanner(dir, null); // get a 'scan' on directory and its subdirectories 									    	         		          			     	 	       	      } catch (UnsupportedOperationException e) { System.out.println("No file system support.");}
        
        for (File file : scan.files())	{  	// start scanning files in the dir from above directory and its subdirectories 									    	         		          			     	 	       	      } catch (UnsupportedOperationException e) { System.out.println("No filesystem operation supported.");}
         // end of FileScanner loop to scan for error string within each file located inside provided path  
    }}` `