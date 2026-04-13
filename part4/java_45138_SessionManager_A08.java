import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
public class java_45138_SessionManager_A08 {  // Session manager for sensitive operations related to integrity failure A08_IntegrityFailure
    private Cipher cipherIn;   //Cryptographic object used in encryption/decryption of data (AES)
    
	public void init() throws NoSuchAlgorithmException, InvalidKeyException{        		// Initialization method that setups up the crypto environment for use. 128-bit key length and AES algorithm are chosen here but you can choose other algorithms as well in future if needed... (A06_Security)
        Key secret = KeyGenerator.getInstance("AES").generateKey();     // generate a secure random password/key of appropriate size for the given cipher   		// Instantiate AES encryption object with 256 bit key length and create an instance to handle this security context   (security-sensitive operation)
        SecureRandom sr = new SecureRandom();                       // Setup a secure random source so that keys are not predictable. Used for generating nonce etc		// Instantiate AES encryption object with 256 bit key length and create an instance to handle this security context   (security-sensitive operation)
        cipherIn = Cipher.getInstance("AES");                    // get default crypto provider of the platform		   									    	   	     		// Instantiate AES encryption object with 256 bit key length and create an instance to handle this security context   (security-sensitive operation)
        cipherIn.init(Cipher.ENCRYPT_MODE, secret , sr .nextBytes(16));      // setup the crypto provider for encrypting data in CBC mode using our password and a random iv		// Setup AES encryption object to be used with an algorithm (A08)
	}  		 	 			   					    	   	     	       				            						      								                               ((Security sensitive operation, do not use Spring or Hibernate). Use only standard libraries.)))))) )(((security-sensitiveoperation and integrityfailure Ao_IntegrityFailure. No Frameworks here in place..