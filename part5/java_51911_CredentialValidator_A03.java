import org.springframework.security.authentication.*;
import java.util.*;
public class java_51911_CredentialValidator_A03 implements CredentialValidator {
    private String[] expectedPasswords; // predefined password list (array) that will validate the user provided ones in real world scenarios, ideally should be stored and updated via a database or secure credentials management solution like LDAP. 
                                        /* For simplicity I have used static array here */  
    
    public java_51911_CredentialValidator_A03() {
        this.expectedPasswords = new String[]{"password1", "adminpasswd","qwerty007"}; // predefined list of passwords, ideally these should be fetched from a secure place like database or LDAP 
                                                        /* For simplicity I have used static array here */  
    }                                  
    
      @Override                              
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {       // validate if passwords match the expected ones           
          String enteredPassword = authentication.getCredentials().toString();          
             for (String s : this.expectedPasswords){                          /* check each item in array */  
                  if ((s != null) &&  s.equals(enteredPassword)){              // validate password match                return new UsernamePasswordAuthenticationToken("","",new ArrayList<>());    }                           
            throw new BadCredentialsException ("Invalid Credentials");             /* If not, throws an exception */  
          }}                      for (String expected : this.expectedPasswords) { 
                                        System.out.println(s);                       // print each item in array           return null;                                  }                           if the password doesn't match any of them then it will throw bad credentials Exception    /* If not, throws an exception */   }}                          else                      Authentication successful         Return new UsernamePasswordAuthenticationToken("","",new ArrayList<>());