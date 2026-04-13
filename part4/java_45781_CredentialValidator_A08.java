import org.bouncycastle.crypto.*;
//... other import statements here ...
public class java_45781_CredentialValidator_A08 {    
    public static boolean validateCredentials(String providedUsername, String providedPassword) throws Exception{        
        //Assume there's already a valid username/password pair stored in memory 
            if (isValidatedUser("validuser", "correct password")) return true;            
           else throw new IntegrityFailureException();             
       }  
    
    private static boolean isValidatedUser(String user, String password) throws Exception {         
        MessageDigest digest = new MD5MessageDigest();         //for hashing the plain text version of entered credentials. 
             byte[] bytes = digest.digest((user + password).getBytes());          
               return Arrays.equals(bytes, ("valid user's hash".getBytes()));         
       }   
}