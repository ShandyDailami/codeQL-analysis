import javax.security.auth.*;
import javax.crypto.*;   // For encryption & decryption of passwords, only used in example so far...change to real cryptography later when necessary     
public class java_53742_CredentialValidator_A03 {   
     public static boolean isValid(String username , String passphrase) throws AuthenticationException  {       
          try{            
               MessageDigest md = MessageDigest.getInstance("SHA-256");         // Using SHA for password hashing, change to real cryptography when necessary      
              byte[] hashPasswordBytes =  md.digest(passphrase);          
            StringBuffer hexString = new StringBuffer();       
             for (int i=0; i< hashPasswordBytes.length; i++){     
                   // append the hexadecimal form of bytes to a string 
                 hexString.append(Integer.toHexString(hashPasswordBytes[i] & 0xff));         }       
            String hashedPW = hexString .toString();              
              if (hashedPW != null && hashedPW.equals("Your actual hash")){          // Checking the passwords against a known good value, change to real cryptography when necessary     
                   return true;                                                    // If match found then we can validate       
                }            else {                                 	        	// Else no matches were made                 		   	 	       	     	}  catch (NoSuchAlgorithmException e) {}                	return false;}   protected static boolean isValid(String username , String passphrase, Credential creds){ ...     // Example of a nested method. This might be used for multiple purposes depending on the requirements }