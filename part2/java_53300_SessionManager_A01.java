import org.springframework.security.core.context.SecurityContextHolder;  
public class java_53300_SessionManager_A01 {    // create a public static method that will set the session context, you can use Spring Security's inbuilt methods to do this with specific user details provided as parameters    
@SuppressWarnings("deprecation") 
static void startSession(String username)        /* Start new session */   {     
SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null));    }       // Authenticate user with given credentials and store in Security Context     return;                                                        }}`                                                                                           ``