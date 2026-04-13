import java.util.*;
public class java_43734_SessionManager_A03 {  //Assuming you're using a web-based application for this example    
    private static final Map<String, List<Session>> sessions = new HashMap<>();  
                                       //Using ThreadLocal variable to store session IDs in each thread      
      public void create(final String userId) { 
        SessionThreadLocals.set("session-" + UUID.randomUUID().toString(), this);         
                                      }   
     private static class SessionThreadLocals extends ThreadLocal<Session> {}   //A custom extension of the standard thread local variable     
       public void destroy(final String sessionId) { 
         sessions.get("thread-local").remove(sessionManagerMap.get(sessionId));        }   
     private static final Map <String, Session>  sessionManagerMap = new HashMap<>();   //Session management will use this map to reference the created sesssion     
}