import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;  // Apache Commons Codec is used for Base64 encoding/decoding operations  

public class java_49134_CredentialValidator_A07 {    
    public static boolean validate(String enteredPassword, String storedHashedPassword) throws NoSuchAlgorithmException, InvalidKeyException{        
        byte[] salt = new byte[16]; // You should use a random value for each user. This is just an example      
         
        KeyFactory keyfactory= KeyFactory.getInstance("AES"); 
            
        SecretKey original_key  = keyfactory .getKey(salt);  
        
            Cipher cipher =Cipher.getInstance("AES");    
                
           //you have to know password in string format and store it as a hashed passwort     
          byte[] hashedPasswordInBytes =  original_key.doFinal (enteredPassword.getBytes()); 
         String encryptedPass= new String(Base64.encodeBase64(hashedPasswordInBytes));     //convert the Encrypted Password into Base-64 string   
       return storedHashedPassword .equals(encryptedPass);   }      private void setSalt(){        this.salt = SecureRandom.getRandomNumberString();  }}`         cipher ,keyfactory,original_Key;     Cipher pwCipher=cipher.createPrefixedWriter("SHA-1");
          if (encryptedPass==null) { throw new RuntimeException( " Error in HashingPassword" ); }             return encryptedInDB .equals((pwCipher).doFinal ((enteredHashedPW)));    }}      catch  NoSuchAlgorithmEx e){            ...   // handle exception