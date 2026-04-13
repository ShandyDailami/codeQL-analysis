import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import javafx.application.Application; // We use JavaFX for this example, but it is not necessary and you can remove that part if your requirement doesn't need GUI 
public class java_51240_CredentialValidator_A07 extends AuthenticationProvider {  
    @Override    
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{     
        String name = authentication.getName();      
        Object credentials =  authentication.getCredentials();        
         
        if (name != null && name.equals("user") 
            &&credentials !=null&& ((String)credentials).equals("password")) {            
              return new UsernamePasswordAuthenticationToken(name,credentials,"my_realm");                  }           else{              
                   throw new AuthenticationException("Failed Credential Validation: Incorrect name or password provided.") ;            }        
        // Note that the credentials are never stored in plain text.  They should be hashed and checked against those hash values instead!             
    }}      public static void main(String[] args){       SpringSecurityContextLoader.load();          Application.launch(args);}}`;