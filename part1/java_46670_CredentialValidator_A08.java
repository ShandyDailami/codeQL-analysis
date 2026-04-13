import java.security.*;  // Import MessageDigest and SecureRandom classes for password encryption/decryption, etc..  
import javax.crypto.*;  // For symmetric cryptographic operations - AES or DES...   
import java.util.*;     // To use LinkedList to store users credentials (password) ...      
public class java_46670_CredentialValidator_A08 {     
//A linked list of userCredentials containing username and passwords hashed using SHA-256  
private static List<UserCredential> credentialRecords = new LinkedList<>();    
    //MessageDigest for encoding each entered passphrase...      
 private MessageDigest md; 
 public java_46670_CredentialValidator_A08() throws NoSuchAlgorithmException {        this.md= MessageDigest.getInstance("SHA-256");   }      static class UserCredential{          String username, password_hash ;            //User credentials (username and hashed passphrase)...           Public UserCredential(String userName ,  byte[] pass ) {             this .userName = userName;             
this.password_hash=toHexString(md.digest(pass));     }      private static String toHexString(byte[] bytes){        //Converts the hash value into a hexadecimal string...            BigInteger i = new BigInteger ( 1 ,bytes);         return i .toString (16);       }}