import java.nio.file.*;
// Importing SecurityManager for checking permissions and integrity failure 
import javax.management.InstanceAlreadyExistsException;  
public class java_49611_FileScanner_A08 {    // Declaring the Class Name 'SecureFileScanner'     
     public static void main(String[] args) throws Exception{        		// The Main Method is defined here      		          
          SecurityManager sm = new SecurityManager();            			       									  							 														 	           	   
                                                                                                if (sm.checkPermission("modify", Paths.get("/home/")) != null){ // Checking the Permissions    	                                                   	 	       	      }    else { throw new InstanceAlreadyExistsException ("IntegrityFailure");}      		          									 			  
          FileScanner file_scan = FileSystems.newFileScan(Paths.get("/home/"));      // Creating a New Filesystem and Path       	                                  }                                   else { throw new InstanceAlreadyExistsException("IntegrityFailure");}    		          									 			  
          System.out.println("\n File names with their sizes: ");                       	// Print file paths starting from '/home/' directory        	   						   							      	}      while (true);                                  // Infinite loop to keep it running indefinitely	                            }}};       		            }}catch(Exception e){System.err…..