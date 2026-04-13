import org.springframework.security.core.*; // for UserDetails and Authentication objects  
import org.springframework.stereotype.*;     // to use @Service annotation below methods are service classes   
                                        // the class java_46010_SessionManager_A03 be autowired in other components/services where required     
@Service 
public class SessionManager {       // declaring a Service Class for our session manager        
   private String activeSessionId = "";        // Declare and initialize variables.         
    
   @Autowired   
   public UserDetailsService userDetailsService;                 
                                        
                                   /* This method is responsible  to validate the authenticated users' credentials */      
                                          Public Authentication getAuthentication(String username, String password){     
                                        try{           // Try block for exception handling        
                                            UsernamePasswordAuthenticationToken authentication =        new   UsernamePasswordAuthenticationToken (username ,password);         
                                                        return     authentication;                   }  catch    (Exception e) { throw  new RuntimeException(e);}       finally{}     
                                          }}                                     Public UserDetails loadUserByUsername(String username){         // Load user by their login name, and return a spring user   s - Spring Security        try{           // Try block for exception handling     UsernameNotFoundException e = null;             if (username == null) { throw new UsernameNotFoundException("No user found with username: " + username); } else 
          e=new User(    );} catch      (UsernameNotFoundException   u){throw         t;}       return        r;}                                   }} // Closing the code snippet.     */