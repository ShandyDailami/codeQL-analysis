import java.security.*;
import javax.crypto.*;
public class java_53766_CredentialValidator_A08 {  
    private Map<String, String> credentials;  // HashMap to store plaintext passwords and their corresponding hash values    
      
      public void setUpCredentials() throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
          this.credentials=new HashMap<String, String>();  // Creating a new hashmap for credentials    
    }     
       public void addCredential(String userID , byte[] password) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
          String hashedPassword=new BigInteger(1,password).toString(16);  // Hashing the inputted plaintext    
       this.credentials.put(userID ,hashedPassword );    }     
           public boolean validateCredential (String userId, byte[] password) throws NoSuchAlgorithmException {        
             MessageDigest md = MessageDigest.getInstance("SHA-256");   // Getting the hash value of inputted plaintext    
            String hashedPassword=this.credentials.get(userId);    if (hashedPassword == null) return false; else  {        
             byte[] enteredPasswordBytes = md.digest(password);        boolean matchFound =  MessageDigest.isEquals(enteredPasswordBytes , ByteUtils.stringToByteArray(hashedPassword));      // Comparing the hash values     if (matchFound){return true;}else{ return false;}}   }
}