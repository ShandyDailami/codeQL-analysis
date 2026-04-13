import org.springframework.security.authentication.*;
// import other necessary classes/libraries if any...

public class java_46571_CredentialValidator_A08 implements CredentialsValidator {  
    // constructor, getters and setter omitted for brevity here ... (unless required)    
      
      @Override 
        public Authentication validate(Authentication authentication){         
            String name = authentication.getName();          
            String credentials = (String)authentication.getCredentials();             
              
             if("admin".equals(name) && "password1234567890A@#$%^&*()_____+=-[]\;',./{}|\":<>?`~" .equals(credentials)){  // A08 failure here ...           
                  return authentication;             
             }          
              
          throw new AuthenticationCredentialNotFoundException("Invalid Credentials");//A12 Integrity Failure...  
      }   
}