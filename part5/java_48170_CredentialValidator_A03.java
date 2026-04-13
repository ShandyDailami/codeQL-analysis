import java.security.*;   // Import Security Required classes 
import javax.security.* ;    // For JAAS (Java Authentication and Authorization Service) security requirement     
public class java_48170_CredentialValidator_A03 {    
// This is the method where we perform validation         
 public boolean validate(String username, String password){             
   if ((username == null) || (password == null))              
    return false;             // Null values are always not valid           
                              // Length of a user's name and its length        can be checked.     
  MessageDigest md ;         
  try {                     
     /* Create an instance for Digest */          
   md = MessageDigest.getInstance("SHA-256") ;   
       } catch (NoSuchAlgorithmException e)             // No algorithm available           
        return false;              
        
      String input  = username + password  ;         
     byte[] hashBytes =  md.digest(input.getBytes())   ;              // The SHA-256 of the given data is computed here    } catch (Exception e) {                   System . out . println (" Error : "+e);           return false; }}            try{
         /* Create a key generator */       KeyGenerator kgen = 
KeyGenerator.getInstance("AES", 
"BC");     // A KEY GENERATOR is created with the specified algorithm and provider      } catch (Exception e) { System . out   
   . println (" Exception : "+e); return false; }}            /* Create a Cipher instance for encryption          */       try{Cipher cip =  kgen.createCipher( 
"AES");     // A new, default-bound encrypted message is created here           } catch (Exception e) {   System . out   
         . println (" Exception : "+e); return false; }}            /* Encryption of the data */       try{cip.doFinal(input  .getBytes(),0 , input     
          .length());     // The encrypted message is stored in this variable here           } catch (Exception e) { System   
         out        . println (" Exception : "+e); return false;}            /* Printing the Encrypted Data */       try{out.print("\n" + new String(hashBytes));}catch 
      (Exception ex){System..println("Error: Unable to encrypt data." ); }    // Error Handling   }}                catch blocks handle exceptions             e . println (" Exception : "+e); return false;}}}}}