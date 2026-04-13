import java.security.*;
import java.util.Base64;
import javax.crypto.*;
 
public class java_48265_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{        
        String message = "Hello World"; // example data to be encrypted/decrypted      
         
        Key key = generateAESKey();  
     
        byte [] encryptedMessageBytes =  encrypt(message.getBytes(),key); 
              
        System.out.println("Encrypted:    " + Base64.getEncoder().encodeToString(encryptedMessageBytes));        
         
       // Decryption - assuming the same key is used for encryption    
      byte[] decryptedByte =   decrypt ( encryptedMessageBytes ,key); 
        System.out.println("Decrypted:    " + new String(decryptedByte));              
           }            
            public static Key generateAESKey() throws NoSuchAlgorithmException {        
                KeyGenerator keyGen =  KeyGenerator.getInstance ("AES");                
              return (SecretKey)keyGen .generateKey();          // Generating a secret 128-bit AES key        }     private byte[] encrypt(String data, SecretKey secKey){       ...}   public static void main(){    ......}}      The encryption and decryption methods are shown above.