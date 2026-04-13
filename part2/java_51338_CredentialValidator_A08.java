import java.security.*; // Importing standard libraries for cryptographic functions and objects 
import javax.crypto.*;   // For using classes like AES or Blowfish in Java Secure Socket Extension (JCE) 
import org.springframework.util.DigestUtils;    // To use Digests class java_51338_CredentialValidator_A08 Spring Framework, which is a part of spring's util package and it provides static methods for generating digest values ie SHA-256 hashes etc...  
public final class CredentialValidator { 
     private String storedHashedPassword ;      /* The hash value (stored password) that we are checking against */   
       // Creating the key and initializing it with a random iv. This is required when using AES           
         KeyGenerator kg = KeyGenerator.getInstance("AES");  
          SecretKey sk  =kg.generateKey(); 
           byte [] bytes = sk .getEncoded();     /* Converting secret keys into an array of integers */      
        // Creating a Cipher instance for encryption and decryption             
            Cipher cipher=Cipher.getInstance("AES");    // Instance Variable to store the encrypted text  
          IvParameterSpec ivspec = new IvParameterSpec(bytes); /* Initialization Vector which is random */ 
        cipher .init(Cipher.DECRYPT_MODE, sk ,ivspec );         /**/     Crypting a string with this key and initialization vector***/    // Creates an instance variable for encrypted text   bytes of initialisation vector should be randomly generated at the time creating object ****
          boolean integrityCheckFailed = false;      /* Check if we got any failure in our attempts */  public final String validate(String providedPassword) throws CredentialValidatorException {    // Method to check password against stored hashed one   cipher.doFinal() is used for decrypting the encrypted text***/
            try{cipher .update(providedPassword .getBytes());      /* Decryption of user entered Password */  }catch (IllegalBlockSizeException e){ integrityCheckFailed = true;} catch (BadPaddingSizeException e) {integrityCheckFailed=true;}}   if(!integrityCheckFailed ){storedHashedPassword=  cipher.getBytes();} else throw new CredentialValidatorException("IntegrityFailure"); }