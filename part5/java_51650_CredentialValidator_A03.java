import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import javax.servlet.*;
import java.io.*;  
public class java_51650_CredentialValidator_A03 implements AuthenticationValidator<PassportCredentialsAuthenticationToken> {   
@Override     public Authentication validate(final PassportCredentialsAuthenticationToken token)  throws AuthenticationException{         if ("username".equals(token.getPrincipal()) && "password".equals("somehash"))      return new UsernamePasswordAuthenticationToken("validuser", "credentialdata");   else        throw new BadCredentialsException("Bad credentials!");     }   
}