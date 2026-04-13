import javax.security.auth.login.LoginException;

public class java_49555_SessionManager_A07 {    
    private User currentUser = null; // We use a simple global variable to store the currently logged user's credentials (username and password). Replace it with proper authentication logic when you implement SecurityContext in your application later on! 
        
    public void login(String username, String password) throws LoginException {            
        if (!authenticateUserPasswordBasedOnStandardMethod(new UserCredentials(username,password))) {            // Here we assume that standardAuthentication method handles authentication. Replace it with actual logic when implementing AuthFailure mechanism in your application later on! 
                throw new IncorrectLoginAttemptException("Username or password incorrect");            
        }        
                
       currentUser = getValidatedAndAuthenticatedSession(username,password);          // Here we assume that SessionManager can handle session creation and it should validate the user's credentials. Replace with actual logic when implementing AuthFailure mechanism in your application later on! 
    }    
            
   private boolean authenticateUserPasswordBasedOnStandardMethod (UserCredentials cred) {        
       // Here we assume that standardAuthentication method handles password checking based authentication against stored hashed and salted information. Replace it with actual logic when implementing AuthFailure mechanism in your application later on! 
        return true;    
   }     
            
    private User getValidatedAndAuthenticatedSession(String username, String Password) {         // Here we assume that SessionManager can validate user's credentials and authenticate them. Replace it with actual logic when implementing AuthFailure mechanism in your application later on! 
        return new ValidUser();     // For simplicity let us just create a valid User object for our example, you should replace this part by the right validation/authentication procedure based upon user's roles and privileges etc..        
    }     
}