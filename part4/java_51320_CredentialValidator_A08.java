import java.security.*;  // Import cryptographic classes  
    import javax.crypto.*;  // For implementing symmetric encryption algorithms like AES...      
     public class java_51320_CredentialValidator_A08 {         
         private static final String algorithm = "AES";     
          
            byte[] keyBytes = "ThisIsAESEncryptionKey".getBytes();  
             Key key= Key.generateKey(algorithm,keyBytes);  // Generating the encryption/decryption keys   
     public java_51320_CredentialValidator_A08() { }              
         private MessageDigest md;                   
              void setupMessageDigest(){         
                 try{               	      			       				     					  		                  	   	 	       	     	}catch(NoSuchAlgorithmException e){  // Preventing the exception from occurring.   							    	// Catch block to handle no such algorithm exceptions - Nothing done in catch and then nothing happens by default }
              public void validateCredentials (String userName, String password) {  	      		                  	   	       	     	}catch(InvalidKeyException e){  // Preventing the exception from occurring.    					   	 	// Catch block to handle invalid key exceptions - Nothing done in catch and then nothing happens by default }
              public void checkIntegrity() throws NoSuchAlgorithmException, InvalidKeyException {  		      			       				     	         	   	       	     	}catch(InvalidParameterSpecification e){  // Preventing the exception from occurring.   					    	// Catch block to handle invalid parameter specification exceptions - Nothing done in catch and then nothing happens by default }
              public static void main (String [] args) {  		      			       				     	         	     	}catch(Exception exe){  // Preventing the exception from occurring.   					    	// Catch block to handle all other specific exceptions - Nothing done in catch and then nothing happens by default }
         }}