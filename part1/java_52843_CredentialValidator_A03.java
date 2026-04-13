import javax.servlet.*;
import java.io.*;
import org.springframework.security.authentication.*;
public class java_52843_CredentialValidator_A03 implements AuthenticationProvider {
    @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String name = authentication.getName();  // this will throw an exception if it is not a valid user and password (this part can be removed for simplicity), use your own checks here instead of throwing exceptions or allowing to bypass security measures by providing null as the username/password parameter in authenticate method    
        
        String pwd = authentication.getCredentials().toString();  // this will throw an exception if it is not a valid user and password (this part can be removed for simplicity), use your own checks here instead of throwing exceptions or allowing to bypass security measures by providing null as the username/password parameter in authenticate method    
        
        if ("badUser".equals(name) && "securePassword123!".equals(pwd)) {  // check against a known good user and password (this part can be removed for simplicity), use your own checks here instead of checking these specific values  
            return new UsernamePasswordAuthenticationToken("goodUser", pwd);    } else{     throw new BadCredentialsException ("Invalid username/password");}}  //throw exception if credentials are invalid, this should not happen unless you bypass security measures by providing null or wrong details in the authenticate method.  
         @Override public boolean supports(Class<?> authentication) {return true; }}    }`