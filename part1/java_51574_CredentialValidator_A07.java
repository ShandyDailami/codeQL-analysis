import javax.crypto.*;
import javax.security.auth.*;
import org.apache.commons.codec.binary.Base64;
public class java_51574_CredentialValidator_A07 { 
    public static boolean isValid(String username, String password) throws GeneralSecurityException{  
        // Encoding the credentials into Base64 and then decrypting them using a secret key (you can use any random string here).     
            byte[] encodedCreds = Base64.encodeBase64((username + ":" +password ).getBytes()); 
         Cipher cipher =  Cipher.getInstance("AES");   
        SecretKey originalKey  = new javax.crypto.spec.SecretKeySpec(encodedCreds,0 ,128);   //your secret key should be more secure and different for each use case (key length must match) 
       cipher .init(Cipher.DECRYPT_MODE, originalKey );   
         String decryptedPass = new String(cipher.doFinal((password + ":++").getBytes())); //decrypt the password   if you are using this in your real use case then make sure to include ++ as a separator for security purpose else it could be easily manipulated by someone who already has access
        return decryptedPass .equals( (username+":"+password) );    } 
}