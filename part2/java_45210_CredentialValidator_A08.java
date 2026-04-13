import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_45210_CredentialValidator_A08 {  
    // The real data source for usernames and passwords is not used in this example but can be replaced with the actual database or other authentication system's user information 
     private static final String knownUsername = "user";
     private static byte[] hashedPasswordForUser;//password should always start as a hash, so we don’t have to store password plain text in our source. You may use SHA-256 for this purpose (below is an example of storing the result) 
     
    public java_45210_CredentialValidator_A08(String username) { //constructor needs access parameters only if you want it could be more secure and need user data from actual database or other system to validate passwords    	  		         	 	     			       }        
        this.knownUsername = knownUsername;          
 	}            	       	   				     					   							                 hashedPasswordForUser=hashpassword(this); //hashes the expected username' users password using SHA-256, you may use any hash algorithm or a salt for more secure operation		    	  			       }       	     	 								             
  public boolean validate(){//This method takes in an attempted login and validates it against our stored hashedPassword. It should return true if the entered password is correct (matches expected), false otherwise   	   	       								}                                       									         						     		    	  			       }        	     	 								             
  private static byte[] hashpassword(String input){ //Hashes a string using SHA-256. You may replace this with any other secure hashing method such as bcrypt, scrypt etc based on your security needs       	       									     	   	  		    }        	     	 								             
  private static byte[] getSHA(String input){//This is the hash function that generates a SHA-256 for an entered password. It takes in string and returns hashed version of it      	}    			           							                            									                	   	  		    }        	     	 								             
}