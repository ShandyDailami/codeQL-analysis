// Import the standard libraries we'll be needing to use in our code:  
import java.security.*;
    
public class java_50182_CredentialValidator_A01 {    // Define a new Java Class named 'CredentialValidator'.     
       public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeySpecException  {        
           System.out.println("Starting Program...");            
            String username = "exampleUser";  
            String passwordToCheck="password1234567890.";    // This is a simple string which will be hashed and compared with stored hash    	               		          	       	     	   
                                                                        	 			 					       				      						                                                          							      .                             }   else if(username.equals("validUser") && checkPassword()){                     System..println (“Access granted”);}else {System.out.printlns ("Invalid username or password");}}     // The method to hash a clear text string and compare it with stored hashed value:
           }   public static String createHashedPassword(String userpassword, MessageDigest digest) throws NoSuchAlgorithmException{ 	MessageDigest md = null;    if (userpassword ==null || userpassword.length()==0){System..println ("Cannot hash an empty password");return "";}
     try {      mD= java .security.MessageDigest   ..getInstance("MD5"); } catch(java.lang...NoSuchAlgorithmException e) 	{( .... ) return;}    byte[] thedigest =  md.... digest..getDigestOf (userpassword);return HexadecimalFormat.format(the digests));}}}}}