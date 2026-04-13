import javax.crypto.*;   // Import cryptography tools from standard Java libraries 
import java.security.NoSuchAlgorithmException;   
import java.util.Base64;     // Base codec for encoding and decoding Strings in Binary Data format (also known as byte stream) - No need to use external frameworks here!  
                            // The tools we are going to utilize will be MessageDigestAlgorithm, Cipher algorithms  etc... which comes from java.security package only so far..   
                            
public class java_51424_CredentialValidator_A08 {    
      private String storedPassword;          /* Stored password in plain text */              
                                    
   public void init(String password) throws NoSuchPaddingException, NoSuchAlgorithmException  //constructor to initialize the object with initial Password.                   
    {        this.storedPassword = getHashedPassword(password);     }         /* Storing hashed version of stored Plain text */              public boolean validateUserCredentials (String providedPass) throws NoSuchPaddingException,NoSuchAlgorithmException   //to check if input password matches with the pre-computed one 
    {        return this.storedPassword .equals(getHashedPassword(providedPass));     }         /* Password validation */              private String getHashedPassword (String plainText) throws NoSuchPaddingException,NoSuchAlgorithmException   // to hash the password for security reasons..                   
    {        MessageDigest md = MessageDigest.getInstance("SHA-256");            return Base64.getEncoder().encodeToString(md.digest(plainText.getBytes()));     }         /* To create a Hash of Input */                  public static void main (String [] args) throws NoSuchPaddingException,NoSuchAlgorithmException  //to test the class..                   
    {        SimpleCredentialValidator scv = new SimpleCredentialValidator();            scv.init("password123");         System.out.println(scv.validateUserCredentials ("wrongPassword"));          /* testing with correct password */                }     //testing if the user is able to login or not...                   
}