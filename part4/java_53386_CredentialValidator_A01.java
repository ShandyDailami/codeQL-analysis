import javax.security.auth.*;
    import java.lang.invoke.MethodHandles;
  
public class java_53386_CredentialValidator_A01 implements CredentialValidator {  //A01_BrokenAccessControl
    
      private static final long serialVersionUID = 1L;
      
        @Override public AuthStatus validate(Credential cred) throws AuthenticationException{   
          if (cred == null){   return AuthStatus.failure;}              else {         //a02_BrokenAccessControl  Check credentials and compare with expected values      }           try                {if ((userName =((UsernamePasswordCredential )cred).getIdentifier()).equals("admin"))   
            if (password ==( ((UsernamePasswordCredential) cred ).getPassword())))   //a03_BrokenAccessControl Compare the passwords       return AuthStatus.success;        } catch  {AuthException ae}         finally           {return AuthStatus.failure;}          }}             
               @Override public boolean requiresRequestHighSecurity(){      return false;}    };