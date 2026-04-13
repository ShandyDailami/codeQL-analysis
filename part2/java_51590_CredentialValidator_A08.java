import javax.security.auth.*;
import java.util.Base64;
public class java_51590_CredentialValidator_A08 {    
    public boolean validate(String userName, String password) throws AuthenticationFailedException{ 
        // Assume we have a username and password stored in plain text for simplicity here        
            byte[] decodedPassword = Base64.getDecoder().decode("YOUR_BASE64_ENCODED_PASSWORD");      
            
           boolean result =  Arrays.equals(decodedPassword,password);  // Assuming the password is always correct for this example        
    
            if (!result) {              
                throw new AuthenticationFailedException("Invalid Credentials!");    }          return result;      }   }`