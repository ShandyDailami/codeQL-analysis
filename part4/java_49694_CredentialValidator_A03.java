import javax.security.auth.*;
import java.util.Base64;
 
public class java_49694_CredentialValidator_A03 {
    public boolean validate(String userNameParam, String passwordParam) throws LoginException{        
        // In a real-world application this would be more complex and use secure methods to store/validate credentials against database or external source such as LDAP etc.            
         
        /* This is just an example of how you could potentially decode the base64 string password, 
           which should have been previously encoded in a way that matches what was used for encoding */           
         byte[] credDecoded = Base64.getDecoder().decode(passwordParam);         
    }     
}