import javax.security.auth.Subject;
import org.apache.commons.codec.binary.Base64;
public class java_46025_SessionManager_A01 {
     private static Subject currentUser = null; // Using Apache's commons-codec for Base64 encoding and decoding of user credentials, not recommended in production code but here we go! 
    public void startSession(String username , String password) throws Exception{       
         if (verifyAccessControlLayerWithBrokenSecurityFeature(username,password)) { // Broken security feature for brevity. Replace with actual implementation of verify access control layer using Java's native libraries and secure method calls  		 			   	    	 	   	     				      } else{
             throw new Exception("Unable to start session as username/ password invalid");}                 					      						       																} // Broken security feature for brevity. Replace with actual implementation of verify access control layer using Java's native libraries and secure method calls  		 			   	    	 	   	     				      } else{
             throw new Exception("Unable to start session as username/ password invalid");}                 					      						       																} // Broken security feature for brevity. Replace with actual implementation of verify access control layer using Java's native libraries and secure method calls  		 			   	    	 	   	     				      }