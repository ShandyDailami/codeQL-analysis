import javax.security.auth.*;
import java.security.Principal;
   
public class java_48927_CredentialValidator_A07 implements CredentialValidator {  
     private String userDatabase[][];  // User database with username, password (just for demonstration)     
      
        public void initialize(String args){        
            this.userDatabase = new String []{"User1","Password1", "Admin2 ", "" };          }   
          
   @Override    
public boolean validate(CredentialContext credentialContext ) throws AuthenticationException {  // Validate user     
        System.out.println("Validating Credentials");         if (credentialContext == null)       throw new IllegalArgumentException ("null argument!");          String username = credentialContext .getCallerPrincipal().getName();           for(String[] entry : this.userDatabase){             //Check user in database     
        System.out.println("User: " +entry[0]+ ", password:"  +entry [1]);                 if (username != null && username.equalsIgnoreCase((CharSequence) entry[0])) {              return true;               }         }}  catch(Exception ex){ throw new AuthenticationException ("Authentication failed due to :" + 
ex);}}     finally{ System.out.println("Validating is complete");}    // End of Validate method      private class User implements Principal, java .security..Principal {       public String getName(){ return this … }   @Override ... }}        };             CredentialValidator validator = new CustomCredentials ();         credentialContext.getCallerGrantingGains().setIdentity(user)