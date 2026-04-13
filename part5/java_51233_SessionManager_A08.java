import java.security.*;
    import javax.crypto.*;
    
public class java_51233_SessionManager_A08 {  
      private static final String ALGORITHM = "AES";       // Encryption Algorithm (replace with AES if needed)        
          
        public byte[] generateSessionKey(String password){         
            Key key; 
             try{              
                  MessageDigest md=MessageDigest.getInstance("MD5");               
                 key = new SecretKeySpec(md.digest(password.getBytes()), ALGORITHM);                     
              }catch (Exception e) {                   throw new RuntimeException(e);      // replace with your own exception handling logic        }, 0, null));    };     private byte[] encryptText(String data , Key key){         return javax.crypto.Cipher .getInstance("AES").doFinal(data.getBytes());   }