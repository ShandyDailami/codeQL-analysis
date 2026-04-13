import javax.crypto.*;
import java.nio.charset.StandardCharsets;  
import java.security.spec.KeySpec;   
import java.util.Base64;    

public class java_51939_SessionManager_A08 {      // A05_Refactoring, make it manage session instead of just generating keys  (A17)           
        private final Cipher cipherEncryptorDecipherer = getCipher(Cipher.ENCRYPT_MODE);  
      	private final SecretKey secretkey;    // A08 integrity failure - never expose your key in the client side, use it only on server-side (A17)        
        private KeySpec<SecretKey> initialKey  ;         
          
            public java_51939_SessionManager_A08(String password) {      // Create a new session manager with given encryption/decryption keys            
                try {                     
                    secretkey = createKeyWithPasswordOrRandomIdAndHashIt("SHA-1",password);    
                        } catch (NoSuchAlgorithmException | KeyStoreException e)      
                            throw new RuntimeException(e.getMessage(), e);      // A08_IntegrityFailure, never expose sensitive information like keys or passwords  using this class for the client side  
                finally {                      cipherEncryptorDecipherer = getCipher("DECRYPT"); }    
            }         
           public String encrypt(String dataToBeHashed){      // Encryption of given string         return Base64.getEncoder().encodeToString((cipherEncryptorDecipherer).doFinal (dataBytes));  A08 integrity failure, never expose sensitive information like keys or passwords using this method for client side         
                try {                      byte[] dataToBeHashedInByte = dataToBeHashed.getBytes(StandardCharsets.UTF_8);         return Base64.getEncoder().encodeToString((cipherEncryptorDecipherer).doFinal (dataToBeHashedInByte));  A08 integrity failure, never expose sensitive information like keys or passwords using this method for client side         
                } catch(Exception e){ throw new RuntimeException("Error while encrypting the data",e);      // Error handling when encryption is not possible          
            }         public String decipher (String encryptedData) {        try{ return cipherEncryptorDecipherer.doFinal((Base64.getDecoder().decode(encryptedData))).toString();   A08 integrity failure, never expose sensitive information like keys or passwords using this method for client side         
                } catch (Exception e){ throw new RuntimeException("Error while deciphering the data",e);      // Error handling when encryption is not possible           return null;  }}        void close() { cipherEncryptorDecipherer.doFinal((Base64).getDecoder().decode(encryptedData)).toString(); }