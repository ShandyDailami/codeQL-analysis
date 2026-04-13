import org.hibernate.Session;
import java.util.*;
public final class java_44389_SessionManager_A03 {   // Class name must start with a capital letter for convention and naming conventions, not mandatory but good practice to follow it as per Java standards   
     private static Map<Long, Session> sessions = new HashMap<>();  // ThreadLocal variable used here that stores session in each thread so the context is maintained.  
      public void startSession() {                    
           Long userId=getLoggedInUserIdFromSecurityToken(/* Token fetched from User Login*/);     if (sessions.containsKey(userId)) return;    // If already started session then just returns, not creating new one for security reasons   sessions.put(userId , /* open a connection here */ ); 
      }
       public Session getSession() {           
           Long userid = getLoggedInUserID();             if (!sessions.containsKey(userid)) startSession ();         // Start session in case not started yet   return sessions .get(userId) ;    /* Open connection */ 
      }               public void close(){                try { Session s=sessions.get(Thread.currentThread().getId()); if(null !=  s ){    	s.close();		/* Close the session here in case open before*/   sessions .remove (userId);	} catch (Exception e) {} 
      }       public void setUserAsInactive() {          try { Session s=sessions.get(Thread.currentThread().getId()); if(null !=  s ){    	s.evict(*Singleton for the user* );   sessions .remove (userId);	} catch (Exception e) {} } 
}