import javax.crypto.*;
   import sun.security.util.SecurityUtil;     // For CryptoRandomGenerator and SecureRandomImpl, only available in Java6 or later due to lack of standard java cryptography libraries (CVE-2019-5734) 
   
public class java_53825_SessionManager_A03 {
   private static final String ALGORITHM = "AES"; // Algorithm for encrypting the session data, AES is usually a strong encryption algorithm. Other options include DES and RC2 which are less secure but more efficient in terms of CPU use compared to AES 
   
   public byte[] generateKey() throws NoSuchAlgorithmException {
       KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM); // Creates a new instance for the algorithm used (AES, DES etc.)
        return keyGen.generateKey().getEncoded(); 
    }  
     
     public byte[] encryptData(String dataToEncrypt, byte [] key) throws NoSuchPaddingException, NoSuchAlgorithmException { // For encryption we use AES algorithm so no need for padding except PKCS5Pad which is included in the java standard library. 
       Cipher cipher = Cipher.getInstance(ALGORITHM);   
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec (key ,0 , key .length)); // Initializes encryption with our secret key and algorithm  
         return cipher.doFinal((dataToEncrypt).getBytes());  // Encrypted data is returned in bytes so we need to convert it into string after decryption for readability    
    }     
       public String decryptData(byte [] encryptedText, byte[] encryptionKey) throws NoSuchPaddingException ,NoSuchAlgorithmException {   // Decryption function. We use the same algorithm and key as in encrypt method 
         Cipher cipher =Cipher .getInstance (ALGORITHM);   
          cipher.init(Cipher.DECRYPT_MODE,new SecretKeySpec (encryptionKey ,0 , encryptionKey .length)); // Initializes decription with our secret key and algorithm  
           return new String((cipher.doFinal)( encryptedText ) );  }      
}