import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.management.AuthenticationFailedException;
... // imports removed for brevity, add these ones when needed 
public class java_49485_CredentialValidator_A08 {  
    public static void main(String[] args) throws NoSuchAlgorithmException{    
        String password = "password123";            
        
       byte[] hashBytes =  getSHA256Hash(password); // this is the function for hashing         
                                                                                     
      if (isValidPassword("hashedPwd",hashBytes)) {  
           System.out.println ("Login Successful"); 
        } else{   
            throw new AuthenticationFailedException();    
         }      
    }            
... // functions removed for brevity, add these ones when needed     
private static byte[] getSHA256Hash(String input) throws NoSuchAlgorithmException {         
           MessageDigest digest = MessageDigest.getInstance("SHA-256");    
            return digest.digest(input.getBytes(StandardCharsets.UTF_8));        
    }      private static boolean isValidPassword (String passwordToCheck, byte[] hash) {   // this function checks if the hashed input matches a stored one 
           try{          MessageDigest md = MessageDigest.getInstance("SHA-256");    
              byte [] hashBytes  = md.digest(passwordToCheck.getBytes());       return true; }catch (NoSuchAlgorithmException e) {e.printStackTrace();   // if hashing algorithm is not available, catch exception          throw new Runtimeexception("error occurred while validating password"); 
        }}    
}