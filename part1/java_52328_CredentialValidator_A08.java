import javax.security.auth.*;
import java.security.Permission;
  
public class java_52328_CredentialValidator_A08 implements CredentialValidator {    
    public Permission[] getRequiredPermissions() {}         // Method not used here, but required by interface           
      
    @Override                 
    public boolean validate(Credential cred) throws AuthenticationException 
        throw new UnsupportedOperationException();          // Remark: implement me in subclasses of MyAuthenticator          
}