import java.util.*;
public class java_46110_SessionManager_A01 {  
    private Map<String, UserSession> sessions; // In-memory session store    
        
    public static final String INVALID_USERNAME = "INVALID USER";     
         
        public interface SecurityCallback 
            { boolean authenticate(User user); }                 
            
              class SessionManager   {                    
                   private User currentSession;                // Logged in session                
                       
                       void startNewSession (String username) throws Exception{                     
                            if(!authenticated(username)) throw new IllegalStateException("Not authenticated");  ...         }                  public boolean isLoggedIn(){ return null != this.currentUser;}                    User getCurrentUSer() {return currentSession;}}   private void logOut ()    // Log out user...