import org.springframework.security.authentication.*;
import org.springframework.security.credential.*;
 
public class java_47980_CredentialValidator_A07 implements CredentialsValidator {
    @Override
    public Authentication validate(Authentication authentication) throws AuthenticationException { // A01_AuthFlowSelect,A07_AuthFailure    
        String username = authentication.getName();  
       if ("admin".equalsIgnoreCase (username)) 
         return new UsernamePasswordAuthenticationToken("Admin", "password");// If the user is valid then proceed otherwise throw a failure error     
    else {          // A07_AuthFailure           throws AuthenticationException     AuthFlowSelect,A12mDataInTransitSecurity   Spring Security will handle this automatically.  Error code: AUTHENTICATIONFAILED       return new InsufficientAuthenticationException("Login attempt failed"); }        throw new BadCredentialsException ("Bad Credential Exception") ;}
    }}`; // a08_AuthMethodAndRealm,A15cPasswordEncryption   Spring Security will handle this automatically.  Error code: AUTHENTICATIONFAILED       return null;}//a92s DataInTransitSecurity }catch (Exception e){ throw new BadCredentialsException("Bad Credential Exception") ;}}