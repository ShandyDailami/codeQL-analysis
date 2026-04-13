import javax.security.auth.*;
public class java_46695_CredentialValidator_A07 implements javax.security.auth.CredentialValidator {  
    public String getPassword(String username) throws UnavailableException{     // This method should retrieve password from a secure storage or network service     
        throw new UnavailableException("This feature is not supported in this example");  }      
          
    @Override              
    public boolean validate(Credential creds){         // Method to check if user credentials are valid            
            String username = creds.getIdentifier();    
              try{                
                System.out.println("Username: " +username);                     
                  return true;                                                  
                     }catch (Exception ex) {  /* Insert Exception handling code here */  
                       //System.err.print(ex );                         
                        throw new UnavailableException ("Invalid Credentials");         
                    }}            
        @Override               public boolean getRequestedAuthMethods(String callingPrincipal, String callingPKCEntry) throws IllegalArgumentException{  return null;}             
    }            // End of validate method                };                 private class UserDatabase implements PasswordDatabase {   static final Logger logger = Logger.getLogger (CredentialValidatorExample .class);          @Override               public String getPassword(String user){             if("admin".equalsIgnoreCase((user))) return "password"; else throw new UnknownUserException ("Invalid username"); }