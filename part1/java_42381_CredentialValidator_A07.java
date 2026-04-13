import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_42381_CredentialValidator_A07 implements AuthenticationValidator<UsernamePasswordAuthenticationToken> {  
    @Override  public String validate(UsernamePasswordAuthenticationToken token) throws IllegalAuthenticationFailureException{       //validate method    
        final Object principal = token.getPrincipal();      if (principal == null){          throw new InternalAuthenticationServiceException("Null username");         }           UserDetails user  = ((UserDetailsServiceImpl )SpringSecurityContextUtils.getAuthenticationObject()).loadUserByUsername((String)  principal);            
        //check password validity in the database...       PasswordEncoder encoder = EncryptionUtility().encodePassword(user, "database");              if (!encoder.matches("password", user)) { throw new InternalAuthenticationServiceException("Invalid Credentials!"); }                return null;  }}