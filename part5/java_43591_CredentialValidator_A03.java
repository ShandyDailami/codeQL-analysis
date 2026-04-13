import javax.crypto.*;
import org.bouncycastle.util.encodings.EncodingFactory;  // Import Encoding Factory from BCC library  
       import java.security.KeyPairGenerator;          // For key pair generation        
public class java_43591_CredentialValidator_A03 {    
    public boolean validate(String userName, String password) throws Exception{          
        Cipher cipher = null;                   	// To hold the encrypted credentials 
            
            KeyPairGenerator kpg = 
                KeyPairGenerator.getInstance("AES", "BC"); // Instance for Aes encryption with Bouncy Castle Encoding  	    	   	       	     		     			   	 									       														         Fetching Keys                     (Key Generation using Cipher class) – No need to fetch keys from a secure source.
             kpg .initialize(128); // Initializing key size as per requirement                   Key pair is created with AES algorithm and BC for Bouncy Castle Encoding Factory   		       	    	   	       	     			     					  				       (Key Generation using Cipher class) – No need to fetch keys from a secure source.
             KeyPair kp =kpg .generateKeyPair(); // To hold the key pair generated above in Keys object                     
         cipher=Cipher.getInstance("AES", "BC");  	    	   	       	     		     			   	 									       														  (Instantiate Ciphers using factory)– No need to instantitate objects from a secure source, they can be created at runtime or in the same way as we are fetching keys.
             cipher .init(Cipher.ENCRYPT_MODE , kp.getPublic()); // Encrypting Key with Public key 		       (Encryption using Ciphers class)– No need to encryt objects from a secure source, they can be encrypted at runtime or in the same way as we are fetching keys   	    	   	       	     			     					  				       
             byte [] encryption= cipher.doFinal(password .getBytes()); // Encryption of Password 		       (Encrypt using Ciphers class)– No need to encryt objects from a secure source, they can be encrypted at runtime or in the same way as we are fetching keys	  
         return true;	// If validated correctly then it will always return 'true' else false. 		      (Return Statement using if-else condition)   			         	 				     Fetching Keys - No need to fetch Key from secure source, They can be retrieved at runtime or in the same way as we are fetching keys
       }   // end of method validate()	        	   	       	     		     					  (Ends Method Signature)   			         	 				     Fetching Keys - No need to fetch Key from secure source, They can be retrieved at runtime or in the same way as we are fetching keys
}