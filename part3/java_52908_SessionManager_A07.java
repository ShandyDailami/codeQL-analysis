import javax.servlet.*;
import java.io.*;
import org.apache.catalina.*;
import com.sun.security.auth.*; // Importing sun-based authentication mechanisms 
// and the JAAS API for user credentials management (for A07_AuthFailure).  
public class java_52908_SessionManager_A07 implements ServletContextListener, SessionContext {
    private static final String USERNAME = "username";     
    
    @Override public void contextInitialized(ServletContextEvent sce) {}  // No action required here.      
          /* The listener will be invoked by the servlets container when a new session   */       
        
          
    private AuthInfo auth;                                              // Stores authentication information for current request..     
     public void login(String userName, String password) throws AuthenticationException { 
            Map<String,String> map =new HashMap<>();                  /* This will be the parameters you pass to username &password */   
          if (userName==null || "".equalsIgnoreCase(userName))        // No validation required. Just for user name - A07_AuthFailure  *  
            throw new AuthenticationException("Invalid Credentials") ;     /* Exception will be thrown when auth is failed :A06 */   
          if (password==null || "".equalsIgnoreCase(userName))         // Same as above. This time only for password - A07_AuthFailure *  
            throw new AuthenticationException("Invalid Credentials") ;  /* Exception will be thrown when auth is failed :A06 */    map .put (USERNAME, userName);      setCurrentUser(map );          // Set current authentication object.       
         }       public void logout() { if ((auth != null) && AuthUtil.logout((Context)null)) ;   /* Log out the session  and remove it */    auth = (AuthInfo) SecurityConfigurations.getCurrentSecurityConfiguration().invokeHook("[SESSION_LOGOUT]");     }
         public String getId() { return ((auth != null)? AuthUtil.extractSubject((Context)((ServletRequestAttributes) sce).getRequest()) : "no user currently logged in") ;    /* Returns the current users id */  // This is for A05_AuthFailure *  
         public boolean isAuthenticated() { return ((auth != null)? true: false);     }      private void setCurrentUser(Map<String, String> map) throws AuthenticationException{ auth = new AuthInfo(map.get("USERNAME")) ;  /* Create an authentication object and store it */   
}