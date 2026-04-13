import java.security.*;
...
public class java_44056_CredentialValidator_A08 implements CredentialValidator {
    private MessageDigest md; // To compute hash of password and compare with stored in database 
    
    public boolean validate(Credential cred) throws InvalidKeyException, NoSuchAlgorithmException{        
        String userName = (String)(cred.getUsername());          
            byte[] hashedPasswordBytes =  ((byte[])(((SecretKeyInterface) cred).getPassword()));          // get the stored hash of password  in database   
             md= MessageDigest.getInstance("MD5");                   // select a suitable algorithm for computing MD5, if needed     
        ...// compute and compare hashes here (hashedPasswordBytes is your computed hash value)  
         return false;                                             ## If the storedHash does not match with given password then fail  Return true otherwise.   
     }          
}