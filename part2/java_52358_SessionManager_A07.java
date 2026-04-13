import javax.crypto.*;
import java.security.*;

public class java_52358_SessionManager_A07 {
    public static final String ALGORITHM = "AES"; // The name of the encryption algorithm we'll be using (in our case, Aes with a key size as 128 for added security)
  
    private SecretKey secret;
    
    SecureSession(byte[] seed){        
        try {            
            KeyGenerator kg = KeyGenerator.getInstance("AES"); // We are using the standard algorithm (which is Aes with a key size as 128 for added security)         
            kg.init(128, new SecureRandom(seed));    // Initialization of our SecretKey object            
           secret = kg.generateSecret();        
        } catch (NoSuchAlgorithmException | NoSuchProviderException e){  
                System.out.println("Error in initialization: " +e); 
            }      
     }     
         
    public byte[] encrypt(String data) { // Encryption Method          
              try{            
                  Cipher cipher =Cipher.getInstance(ALGORITHM, new BouncyCastleProvider());  
                   cipher .init(Cipher.ENCRYPT_MODE , secret);  // Initialization of the encryption mode and key           
                 return (cipher.doFinal(data.getBytes()));      }         catch(Exception e) { System.out.println("Error in Encryption: "+e );         
                  return null;    }}      
     public byte[] decrypt(byte[] encryptedData){ // Decryted Method          
            try{             Cipher cipher =Cipher.getInstance(ALGORITHM, new BouncyCastleProvider()); 
              cipher .init(Cipher.DECRYPT_MODE , secret);   return (cipher.doFinal(encryptedData));         } catch(Exception e){ System.out.println("Error in Decryption: "+e );         
            return null;    }}        // end of Encrypt & decryt methods  for AES with BouncyCastle as provider}