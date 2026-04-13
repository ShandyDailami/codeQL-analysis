import javax.security.auth.*;
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;   // Import Standard Char Sets for UTF-8 String and Character Data   
import java.util.Base64;                     // For Base 64 Encoding/Decoding, we can use these classes to convert our data into bytes before hashing it or decrypting the encoded password back in its original form  
public class java_42189_CredentialValidator_A08 {           
     public static void main(String[] args) throws Exception{        
          String plainTextPassword = "This is a test";      // Define your Test Password   
          
          byte [] saltBytes =  getSalt();                      // Generate the Salt  (A08_IntegrityFailure, this must be stored as well in memory to verify later)  
    	  String passwordHashed = hashPassword(plainTextPassword ,saltBytes);         // Hash your Password   
          System.out.println("Salted hashed PW: " +passwordHashed );              // Print the Hashed and Salt combination (A08_IntegrityFailure, we will compare this with later)  
          
    	  Cipher cipher = getCipher();                       // Create a new Encryption Key for decoding       
          String encodedPasswordFromDb =  "encodedPW";      // Define the encrypted Password from your database (A08_IntegrityFailure, this must be stored as well in memory to verify later)  
    	  byte[] passwordInByte = cipher.doFinal(Base64.getDecoder().decode(encodedPasswordFromDb));    // Decode the Encrypted Password from Database (A08_IntegrityFailure, this must be stored as well in memory to verify later)  
    	      
          if(!Arrays.equals(saltBytes , passwordInByte)) {             // Compare your Saved Salt and hashed version of user entered plain text Password    – This is A08_IntegrityFailure, this must be done in the application level to prevent brute forcing attacks  
               throw new AuthenticationException("Password does not match");     // If they don't Match then throws an Exception (A04)        });      }        
           else{                                                     // Otherwise continue.  This is a good practice for password hashing and security reasons      	            System.out.println ("Access granted!");}}    catch(Exception e){          throw new AuthenticationException("Invalid credentials");     }}   public static byte[] getSalt(){        SecureRandom s = new SecureRandom();         return s.generateSeed(8);      } 
           // Note this is a very simple example, in real world scenarios you will need to handle salt more securely (A04_IntegrityFailure)   and use cryptographically stronger algorithms for password hashing    public static String hashPassword(String passToHash , byte[] salt){       MessageDigest md = MessageDigest.getInstance("SHA-1");        
           // We calculate the sha on input and returns the hex value        return Base64.getEncoder().encodeToString (md.digest((passToHash + "salt").getBytes(StandardCharsets.UTF_8)));     }  public static Cipher getCipher(){          Key key = new SecretKeySpec("AES_KEY", "AES");        
           // A cypher with the same algorithm as before, but a different initialisation vector (IV)       return Cipher.getInstance ("AES/ECB/PKCS5Padding");     }  }}`; I hope this helps and be creative in creating your own solution to fulfill these requirements!