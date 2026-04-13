import javax.security.auth.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_50444_FileScanner_A08 {    
    public static void main(String[] args) throws Exception{        
        // Authenticate the current user with Kerberos using default credentials (i.e., no ticket-granting handshake). 
	    AuthStatus authStat = javax.security.auth.Subject.login("user");  	    
		    if(AuthStatus.success(authStat) == false){       // Authentication failed, handle the error as you want...        }     	       	 
                  try (Stream<Path> paths = Files.newDirectoryStream(Paths.get("/path_to/directory"))) { 	   	  		   			    									         	// Read all files in a directory          							       // filter out non-security sensitive ones        						            } catch (IOException e){       	 
                       System.out.println("Error accessing the file system: " +e);     	       	     	}                   finally {                    javax.security.auth.Subject.logout();    	  		   			  }}           // Log out after use      									         	if(AuthStatus.success(authStat) == false){
                      System.err.println("Authentication failed, cannot continue");}              }                 catch (Exception e2 ) {System . err println ("exception caught " +e);}}}                  	  		    	  // Catching general exceptions      			  }}   									         	}                  });           	//Capture all errors