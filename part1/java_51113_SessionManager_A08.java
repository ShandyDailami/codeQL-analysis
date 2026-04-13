import java.security.*;
  
public class java_51113_SessionManager_A08 {    
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException{      
        // Create a new instance of the Security Manager        
        SecurityManager security = new SecurityManager();          
              
        Key key = generateRandomSecureKey();         
  
        String plainTextMessage1  = "This is message 1.";    
        byte[] cipherBytes =  performEncryption(plainTextMessage1,key);      
        
		String encryptedMsg= Base64.getEncoder().encodeToString (cipherBytes );    // Encoding the Byte Array to String  
		                                                                                
      System.out.println("Ciphered message is: " +encryptedMsg  ) ;               
        }    
       ...          
}