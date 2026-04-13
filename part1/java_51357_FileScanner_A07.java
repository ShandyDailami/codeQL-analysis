import org.springframework.core.io.*;
import java.nio.file.*;
import javax.security.auth.Subject;
 
public class java_51357_FileScanner_A07 {
    public static void main(String[] args) throws Exception{        
        Path path = FileSystems.getDefault().getPath("path/to/yourFile"); // replace with your file location and name, e.g., "/home/user/" or "C:\\temp"  etc...         
                
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(path)){            
            for (Path p : ds) {                 
                if (!Files.isReadable(p)) continue; // skip non-readable files, e.g., directories or executables                        
                                                   
              try{                            
                 byte[] data = Files.readAllBytes(p);                          
                     Subject currentSubject =  new Subject.Builder().build();// replace with your Authentication logic and obtain the subject  // Assuming you have already authenticated this way           	                 		    					  			   							     				      								        	 	   						         ​        } catch (Exception e) {
                     System.out.println(e);                     
                 }}catch (IOException ex){                             
                    throw new Exception("Cannot read file " + p,ex );             
                };                 
            break;                         // end of loop if needed for specific files            	        		    			  } catch (Exception e) {                     System.out.println(e);               }}                          finally{                                                                                                                   try {   Files.deleteIfExists((p));}catch (IOException ex){System . out println ("Cannot delete file "+ p,ex );}}
        };       //end of directory stream loop  } catch block      if an exception occurs during processing we want to handle it properly             set default runtime environment     System ..println("Error: Cannot find the main method in your class ",e);    e.printStackTrace();   }}