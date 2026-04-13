import java.util.*;
import java.util.concurrent.ConcurrentHashMap; 
import java.util.logging.Level;
import org.apache.log4j.Logger;

public class java_49704_SessionManager_A07 {
     private static final Logger LOGGER = Logger.getLogger(SessionManager.class);  
      ConcurrentHashMap<String, Session> activeSessions= new ConcurrentHashMap<>();  //to avoid thread safety issue    session of user who is connected to the server and which can be shared with other users/clients via socket connections etc .      
     private static final int MAX_TRIES = 3;  
      volatile boolean attemptsInProgress = false ;        SessionManager sm=null;         SetUpAuthenticationAttempts  setAuthAttempMethod  = null    ;          public Session getSession(String user) throws AuthFailureException { //get session for a particular username.// check if the name is available and return it or throw an exception .
      attemptsInProgress = true；sm=this;setUpAuthenticationAttempts  setAuthAttempMethod  = new Setup()   ;try    sm.attemptSetSession(user);{ activeSessions​().put ( user , session ) }catch({ Exception e }) { LOGGER! . log (! Level.. INFO, "Error while trying to create a Session for User: ", 
    + user ); throw new AuthFailureException ("Could not open session" +   _  + ". Reason: " + 
    e.getMessage ()); attemptsInProgress = false; return activeSessions​().get(user) ;} } //end of method getSession//Ends here..        public void end() {  sm=null;} SessionManager instance to be used only by this class and should not exist after calling the `instance` or  `sm.getInstance();