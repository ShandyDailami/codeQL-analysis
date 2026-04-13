import java.security.*; // Import for hashing, message digests etc...  
        
public class java_50587_CredentialValidator_A07 implements CredentialValidator {    
    private MessageDigest md;     
         
        public void initialize(String algorithm) throws InvalidParameterException{          
            if (!"MD5".equalsIgnoreCase(algorithm))  throw new InvalidParameterException("Only MD5 is supported");            
                 
                this.md = MessageDigest.getInstance(algorithm);    // Obtain an instance of the desired hash function          }