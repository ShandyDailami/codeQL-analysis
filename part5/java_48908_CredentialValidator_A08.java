import java.security.*;
public class java_48908_CredentialValidator_A08 {  
    public static MessageDigest digest; // Using SHA-256 hash function for secure storage and comparison of passwords    
      
      /** Initialize the message digestion algorithm */          
        private void init()  throws NoSuchAlgorithmException{            
            this.digest = MessageDigest.getInstance("SHA-256");         }   
              // Hash function is used to convert input into hash value  
      
      /** Method that takes a plain text password and returns its hashed equivalent */ 
        public String getSecurePassword(String passPhrase, byte[] salt){          
            this.init();            
          MessageDigest md = MessageDigest.getInstance("SHA-256"); // Instance of SHA algorithm  
             
         md.update(salt);  // Salt input to the hashing function               
        byte [] bytes = md.digest(passPhrase.getBytes());     // Digests password into a hash value    return new String(bytes);               }            @Deprecated             public static void main (String[] args) throws NoSuchAlgorithmException {   getSecurePassword("password", "salt".getBytes()) ;  }}