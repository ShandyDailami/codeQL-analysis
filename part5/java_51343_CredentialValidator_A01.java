import java.security.*;
  import javax.crypto.*;
  
public class java_51343_CredentialValidator_A01 {
    private Cipher cipher; // For symmetric encryption/decryption using AES algorithm with key derived from password for better storage & retrieval security (AES is a block based transformation, so keys are typically kept secret) 
    
    public void initCipher(String algorithm, Key key){  
        try {        	
            cipher = Cipher.getInstance(algorithm);         		     			      										cipher=null; } catch (Exception ex)            	{try{cipher =  java.security.Security.getImplementation().create("AES/CFB8/NoPadding", key, new javax.crypto.spec.SecretKeySpec ("password".getBytes(), "AES"));}catch(java.lang.UnsatisfiedLinkError usel){ /*use other cipher*/cipher =  Cipher.getInstance ( algorithm ); } catch (Exception ex2) { throw new Error (ex2); }}
       // The initCipher method will be used to initialize the symmetric encryption/decryption with a password derived key and AES block based transformation mode  	    		     			   									  cipher = Cipher.getInstance(algorithm, "SunJCE"); } catch ... {/*handle exceptions*/}
       // Then use this newly created instance of `Cipher` to encrypt/decrypt your data as needed (for example: for storing in a database or passing over the network).  	    		     			   									  public byte[] doEncryption(byte [] plainText, Key key){ try { cipher.init( Cipher.ENCRYPT_MODE ,key); } catch ... //handle exceptions... return encrypted text;
       }}//end of secure credential validator class}