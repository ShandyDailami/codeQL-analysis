import java.security.*;
import javax.crypto.*;
import static org.apache.commons.codec.binary.Base64.decodeBase64;  
 
public class java_47804_SessionManager_A08 {   
     public String encrypt(String value, Key key) throws NoSuchAlgorithmException , InvalidKeyException{        
        Cipher cipher = Cipher.getInstance("AES");         
        cipher.init(Cipher.ENCRYPT_MODE,key);      
           return new BASE64Encoder().encode(cipher.doFinal(value.getBytes()));    }    
      public String decrypt (String value , Key key) throws NoSuchAlgorithmException, InvalidKeyException{         
         Cipher cipher =Cipher.getInstance("AES");          
        cipher .init((Cipher.DECRYPT_MODE),key);       return new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(value)));    }     public static Key generateKey() throws NoSuchAlgorithmException {         //generate a key and print the encoded representation of it
        Key key = KeyGenerator.getInstance("AES").generateKey();      return  new String (keyBase64);   }}`}       BASE64Decoder decoder=new Base64Decoder(){}    }