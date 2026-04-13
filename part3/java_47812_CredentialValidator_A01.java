import org.springframework.security.authentication.*;
import javax.servlet.*;
import java.io.*;  
public class java_47812_CredentialValidator_A01 implements CredentialsContainer, Authenticator {   
      //This is the method that will be invoked by Spring Security when trying to authenticate a user  in our custom credentiaLvalidtor implementation    
       @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException{         
           String name = authentication.getName();  
            char[] password =  (char array [] )authentication .getCredentials();      //This will be the actual passed in username and user's credentials, not a decrypted version        return null;    }     if(name==null || "".equalsIgnoreCase(password)){          throw new BadCredentialsException("Username or Password is incorrect");  
           else{         Authentication auth = SecurityContextHolder.getContext().authenticate(new UsernamePasswordAuthenticationToken ( name, password));      return  null; }}}     public boolean supports(Class<?> aClass){return true;}    private class Encryption {//This is just for encryption in the custom credential validator implementation        static char[] encryptDecryptStringBasedOnKeyCharacterArray("", "".toCharArray()); //Your logic to implement this method }}