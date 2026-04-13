import javax.crypto.*;   // For encryption/decryption, hashing etc.,   
import javax.security.auth.*;      // Contains exceptions for authentication failures    
import java.nio.charset.StandardCharsets;       // Needed to convert string into bytes (need not be in A07_AuthFailure) 
  
public class java_49595_CredentialValidator_A07 implements CredentialValidationListener {   
        @Override            
         public boolean validate(UsernamePasswordCredentials credentials){    
               String plainText = new String(credentials.getPassword(),StandardCharsets.UTF_8);      // Convert password into string (need not be in A07_AuthFailure) 
                  try {      
                     MessageDigest md=MessageDigest.getInstance("SHA-256");     /* Using SHA-2 for hashing */         
                       byte [] hashPassword =md.digest(plainText.getBytes());      // Hashed password is stored in the variable "hashpassword" 
                      StringBuffer sb  = new StringBuffer();  
                     for (int i = 0; i < hashPassword.length ;i++){     /* Converting byte into hexadecimal format */          
                         sb.append(Integer.toString((hashPassword[i] & 0xff) + 0x100, 16).substring(1));    // Get complete hex string for each bytes  
                     }      
                      String encryptedPass =sb.toString();      /* Storing in the variable "encryptedpassword" */    
                       if (encryptedPass .equals(credentials.getPassword())) {          return true;        }         else{           throw new CredentialException("Invalid password");    }}  catch (NoSuchAlgorithmException e)       {e.printStackTrace();}}catch (IllegalStateException | BadPaddingException| IllegalArgumentException |  WrongKeySizeException  | SignatureException ex){ex.printStackTrace()}     return false;} }