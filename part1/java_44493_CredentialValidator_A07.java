import java.security.*;   // For Crypto and MessageDigest classes (included in Java SE) 
...   
public class java_44493_CredentialValidator_A07 implements javax.security.auth.login.CredentialValidator {    
         public boolean validate(javax.security.auth.credential.Credential credential){            
                 String input = new String(credential.getCredentials()); // get password from user 
                 
                 MessageDigest md;    // for hashing the entered credentials  
                 byte[] hashBytes;     // to hold encoded bytes of resultant digest         
                         
                     try {       
                             md=MessageDigest.getInstance("MD5");       // instance MD5 Digest            
                             
                             /* next line can be replaced with any stronger hashing algorithm if required */     
                             md.update(input.getBytes());    // update the password bytes  to hash them  
                         
                             hashBytes =md.digest();     /// obtains digest of input (password), then converts it into hexadecimal format         
                             
                         } catch (NoSuchAlgorithmException e) {      /* handles any errors that may occur */       // catching an exception    ...         return false;   if there is a mismatch in the hashes, otherwise true.  If passwords don't match it returns 'false'.                 };             
                         
                         StringBuffer hexString = new StringBuffer();     /// appending each byte of hashBytes to string buffer         
                                         for(int i=0;i<hashBytes.length;i++){        // converting bytes into Hexadecimal format         ...   }                      return false;}      };    /**/  This method will be called by JAAS when authentication fails and it is used here to check the failed attempts from clients in AUTH_FAILURE context