import javax.crypto.*;
import java.security.Key;
import java.util.Base64;
 
public class java_47449_SessionManager_A08 {
    private Key key;
    
    public void setCipher(String secret) throws Exception{      //Encryption/Decryption using SecretKeys      
        Cipher cipher = Cipher.getInstance("AES");              //Getting instance of AES with the chosen keysize (128 for example, but could be different sizes too). 
    	SecretKey keyForCipher= new SecretKey();                 //Creating a secret encryption/decryption Key   For this case we are using RandomNumberGenerator     
        cipher.init(Cipher.ENCRYPT_MODE,key);                  //Using the Encrypted mode and our previously generated KEY  for initialization of Ciphers    
    }      
        	            
}