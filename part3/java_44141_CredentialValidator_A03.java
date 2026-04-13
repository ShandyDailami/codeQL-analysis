import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
  
public class java_44141_CredentialValidator_A03 implements CredentialValidator {   
    
 @Override      // Method to validate username and password before authentication process starts 
 public Authentication authenticate(Authentication auth) throws AuthenticationException         {          List<GrantedAuthority> authorities = new ArrayList<>();           return null; }       
  
@Override       // After the successful login, user roles will be loaded here. We can implement our custom logic to load from DB or cache   
public void validate(Authentication auth) throws AuthenticationException {          List<GrantedAuthority> authorities = new ArrayList<>();  }}