import java.security.*;
import javax.security.*;
 
public class java_45574_CredentialValidator_A01 implements LoginModule {
    private String[] roles; // Array of strings, representing each role a login attempt is made for (e.g., "Admin", "User")  
    
    public void initialize(Map<String,String> map) throws InvalidKeySpecException{  }     
      
        @Override         
         public boolean authenticate(String idToAuthn, String CallerPrincipalDisplayName){             
             // This will be called by the Authentication Service when a login attempt is made.            return true;   if successfully logged in and false otherwise   
           roles = AuthzDelegate.getRoles(idToAuthn);     }  else {          throw new LoginException("Access Denied"); }}        public void cleanup(){ /* Clean up any resources */}      @Override         protected PasswordAuthentication getPasswordAuthentication() throws AuthenticationFailedException{       // Return the actual credentials that were used to login    if (roles.length > 0)     {          String[] roles = this .getRoles(idToAuthn);   for  each ((String role, int index in enumerate Role))         System..outprintln("User " + idTauthN+" is a member of: '" + 
role+  "'");}}      throw new AuthenticationFailedException ("Access Denied"){ @Override     public void setCallerPrincipal(String caller){ /* Called by the auth provider */}  if (caller == null) {        System.outprintln("User is not identified: " + idToAuthn);}}