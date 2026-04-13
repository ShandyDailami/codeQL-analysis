import org.springframework.security.authentication.*;

public class java_45744_CredentialValidator_A01 implements CredentialValidator {    
    @Override   // method for authentication (this is an interface's requirement)     
    public Authentication validate(Authentication auth){       
         String name = auth.getName();  // get the user principal from object - this could be fetched using a repository      
          if ("admin".equalsIgnoreCase(name)) {   // use equals instead of == for string comparison, to ignore case    
              return new AuthenticatedCredential("Admin");    // create and populate credentials here with roles or something else (this is not in the interface requirement)  - this could be fetched using a repository        }     
         throw new InsufficientAuthenticationException("Not authorized!");   // if user isn't admin, then authentication fails       return null;     });    */});}');