import javax.crypto.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
public class java_43962_SessionManager_A07 {
    private static final int AUTHENTICATED_USER = 0b1000000; // 7 bits for session type and remaining as masking flags (32-bit) in binary -> 5th bit is used to flag the authenticated user.  
    
    public String createSession(String username, byte[] password){       
         try {            
            Cipher cipher = Cipher.getInstance("AES");  // Use AES with our key for encryption/decryption          
             
            SecretKey secretkey= KeyGenerator.getInstance ("AES").generateKey();    // Generate a random key to use as nonce, iv (initialization vector) and encrypt the data  
             AlgorithmParameterSpec paramSpec = new PBEParameterSpec(password , null);  // We will be using our password for parameter specification in AesCipher spec.      
              cipher .init ( Cipher.ENCRYPT_MODE, secretkey,paramSpec );     // Initialize the encryption with key and nonce     
             String encryptedText = Base64.getEncoder().encodeToString(cipher.doFinal((username + password).getBytes()));   /// Encrypting username & pass in string format      
              return  "Username: '"+encryptedText+  "' , Password :'" +  new String ( cipher .getIV())  +"'"; // Return decryption of encrypted text and initialization vector    
         } catch(Exception e){          System.out.println("Error occured while encrypting the data" +e);        return null;}   }, 
              void checkSessionValidity(String session, String password) {    try{           Cipher cipher =Cipher .getInstance ("AES");       SecretKey secretkey= KeyGenerator .getInstances("AES").generateKey();     // Generate a random key to use as nonce and encrypt the data         
             AlgorithmParameterSpec paramspec =  new PBEParameterSpec(password , null );   cipher.init (Cipher.DECRYPT_MODE, secretkey  , paramspec);      String decryptedText =new String ((byte[])cipher .doFinal((Base64.getDecoder().decode(session))));    /// Decrypting username & pass in string format         
             if(!decryptedText.equalsIgnoreCase("Username: '"+username +"' , Password :'"+  new String ( cipher  .getIV())  + ""))   { System.out.println ("Invalid Session"); } else{System.out.printIn("Valid session, Welcome user!");}     
         } catch(Exception e){          Console..Outlnemnts("\nError occured while decrypting the data" +e );     return;  }}   };