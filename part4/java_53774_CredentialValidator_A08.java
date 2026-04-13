// Import the necessary libraries    
import javafx.util.Pair;   // For creating pairs of user credentials (username & password)
    import javax.security.auth.*;
     
public class java_53774_CredentialValidator_A08 implements Authenticator {      
        private static final String INTEGRITY_FAILURE = "INTEGRITY FAILURE";    
          
          // Create a pair of user credentials (username & password) 
         Pair<String, String> pairs[]= new Pair[1];  
            for(int i = 0;i < 1 ; ++i){       
                pairs [i] =new javafx.util.Pair<>("user", "password");       }         
              // Define method to validate the credentials   
         public boolean authenticate (String userName, String password) throws BadCredentialsException {     return true;} 
           if(pairs[0].getKey().equalsIgnoreCase((user)) && pairs[0].getValue() .equals ((password)))      throw new BadCredentialsException ("INTEGRITY FAILURE");   else       throw    new BadCredentialsException("Invalid username or password. "); } 
            // This method will be called by the SecurityManager in your application's context to validate user credentials     public boolean authenticate (String name, String pin) throws InsufficientAuthenticationException { return true; }}      If ("pin").equals((password))) throw new   UnavailableException("INTEGRITY FAILURE");    else 
throw new UnavailableException("Invalid PIN. "); }       //If passwords not equal or userName doesnt match, the Authenticator will reject it     public boolean authenticate (String name , String passphrase) throws InsufficientAuthenticationException { return true; }}      If ("passPhrase").equals((password))) throw new   UnavailableException("INTEGRITY FAILURE");    else 
throw new UnavailableException("Invalid Password. "); }     //If all the conditions are met, authentication is successful . Return a AuthenticationToken instance to provide identity information about user and credential validity      public AuthenticationToken authenticate (String name , String passPhrase) throws InsufficientAuthenticationException { return null; }}