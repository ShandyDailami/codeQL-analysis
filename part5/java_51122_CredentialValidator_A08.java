import java.security.*;   // Import cryptographic functions such as MessageDigest, KeyPairGenerator etc...
import javax.crypto.*;    // For symmetric encryption algorithms like DES and AES ...etc..

public class java_51122_CredentialValidator_A08 {
     private final MessageDigest digest; 
     
     public java_51122_CredentialValidator_A08() throws NoSuchAlgorithmException{  
         this.digest = MessageDigest.getInstance("SHA-256"); // Creating a SHA hasher    }           
         
        /* Alternative for other algorithms like MD5, etc you can use digest = 
           MessageDigest.getInstance(algorithmName) */ 
     }  
      public String generateHashPassword(String password){      
         byte[] hash = this.digest.digest(password.getBytes());        // Hashing the user's input         
         return bytesToHexaDecimal(hash);                       // Converting to hexadecimals           }           
      public String generateSecurePassword(String password, Key key){      
         byte[] encrypted = null;  
               try{   
                    Cipher cipherer =  Cipher.getInstance("AES");         
                  SecretKey secretkey  = new SecretKey();             // Creating a random SecreteKEY for encryption and decryption            }              if(this.secret_password !=null) {     return this;         }}catch (Exception e){    System.out.println ("Error while encrypt/decrypt");}}
                   cipherer .init(Cipher.ENCRYPT_MODE, key);          // Encryption mode            }   else{           Cipher  dec =cipherer ;     if(!this.secretPassword) return null;         try {    Decoder d  =decryptMode (dictionary , ciper here );       
                     String originalPass= new String(UTF_8);             //Decryption mode                } catch   ...exceptions            System .out..println("Error while deciphering");}}}  this.secretpassword =null;}} return null;}         public static void main (String [] args){    CredentialValidator cv = 
                      newCredentials();        if(cv !=NULL) {       // Call the method for creds, like in login or signup             } System .out..println ("User not found");}}}else{            User user = get_user (username);if(!isPasswordCorrect )  return;   print out "welcome back" + name;}