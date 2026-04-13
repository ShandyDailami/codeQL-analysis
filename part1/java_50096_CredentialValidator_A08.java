import java.nio.charset.StandardCharsets;   // for ByteBuffer, StandardCharsets are available from Java 7 and beyond as well but here I am using older standard charset which is enough in our case (as long as we're not dealing with ASCII characters) to keep it short
import java.security.*;                    // the cryptography library that includes hashing functions - SHA-256 for example, etc... 
   import javax.crypto.*;                   // this provides Cipher class java_50096_CredentialValidator_A08 is used here (we need symmetric algorithms like AES). If you're using asymmetric ciphers then use KeyPairGenerator and SecretKey..and vice versa   
import java.util.Base64;                  // for Base 64 encoder/decoder    
  
public class CredentialValidator {        // We are creating a simple validator, so let's name it this way...     
                                          
       public static String hashPassword(String password) throws NoSuchAlgorithmException{    /* here we use SHA-256 which is an example */ 
         MessageDigest digest = MessageDigest.getInstance("SHA-256"); //We get instance of hashing algorithm, in this case 'sha' it represents hash function used by the message digester  
        byte[] encodedPassword= password.getBytes(StandardCharsets.UTF_8);  /*here we are encoding our plain text into bytes (hashable units) */   
         digest.update(encodedPassword); //updating data to be hashed and calling update() method on the hash instance  
          byte[]bytes =digest.digest();     /// taking a finalized result - it is similar as string in C#, an array of bytes that represents password's encoded form    – here we are using MessageDigests which do not provide hex representation thus Base64 required to convert the hash into readable format
           return Base64.getEncoder().encodeToString(bytes);   // Convert byte[] to base64 string and then returns it     }     
                                                           
       public static boolean validatePassword (String enteredPassword, String storedHash) throws NoSuchAlgorithmException {    /// This method will use hash of user password also provided as input by the users in order for comparison. 
         MessageDigest digest = MessageDigest.getInstance("SHA-256");   //We get instance with SHA algorithm..Again, here we are using 'sha' it represents a hashing function used on our message digester object   
          byte[] encodedEnteredPassword= enteredPassword.getBytes(StandardCharsets.UTF_8);  /// Here user enters the password which is to be checked for validation against stored hash in system  
         digest.update(encodedEnteredPassword ); //Here we are updating our message digester object with actual data and calling update() method on MessageDigest instance   
          byte[]bytes =digest.digest();  /// It's similar as string comparison, it is a finalized result that takes password encoded form after hash operation performed using SHA algorithm   // here we are getting the hashed user enteredPassword in bytes format and storing into 'byte array'. Now compare these two byte arrays for equality to show whether they match or not.
          return MessageDigest.isEqual(bytes, Base64.getDecoder().decode(storedHash));  /// Convert stored hash (base-encoded string) back in bytes format and then use isEquals() method on the hashed user enteredPassword's message digester instance to compare it with our previously encoded password  
                                                             }      // if both are equal, return true else false.       };    */  ** End of Code**}