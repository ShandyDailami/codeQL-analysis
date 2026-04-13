import org.springframework.security.authentication.*;
import java.util.*;
public class java_52773_CredentialValidator_A08 implements CredentialValidator {
    @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException{ // Method to validate user credentials }
        String username = authentication.getName(); 
       /* Password here is plain text and not secure for real application, use a method like BCryptPasswordEncoder or similar */  
         if("admin".equals(username)) {    return new UsernamePasswordAuthenticationToken (username,"password", AuthorityList.createAuthorityList ("ROLE_USER")); }  else{ throw new AuthenticationException ("Unknown user") ;} //Change password as per requirement here also security is not respected in this simple example
        /* Use the below method to hash and verify a plain text password */  
    public boolean supports(Class<?> authentication) { return UsernamePasswordAuthenticationToken.class.isAssignableFrom (authentication); } //Check if supported class for Authenticating user credentials 
}