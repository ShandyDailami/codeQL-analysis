import java.util.*;
public class java_45452_SessionManager_A08 {  
    private static Map<String, UserSession> sessions = new HashMap<>();  // userId to session mapping    
      
      public void startSession(User u) throws A08_IntegrityFailure{       
          long now = System.currentTimeMillis() ;        
           String id=u.getId().toString();   
            if (sessions.containsKey(id)) {  // check user's session is already started or not     
               throw new A08_IntegrityFailure("Session Already Started for this User");                 } else  
             sessions.put( id,new UserSession());       
           Session s=sessions.get(id);    
              // set the start time of session  and userId   
               s.setStartTimeMillis (now) ;     
            s.user = u;          }   public void endSession(User U){         if(! sessions .containsKey ((U).getId())) throw new A08_IntegrityFailure ("No Session for this User");     else    //if session is not expired, then update the last access time of user
              (sessions.get((U)).lastAccessTimeMillis() = System.currentTimeMillis(); }   public boolean isValidSession(User u){         if (! sessions .containsKey ((u).getId())) return false; else {      long now=System.currentTimeMillis () ;       
            Session s =  (sessions get((userId))       //check the user session  TTL and current time   
             if(!s.getStarttime() + Constants .SESSION_LIFETIME >now ) return false;      else    
              ((UserSession) sessions).setLastAccessTimeMillis( now );        User u = s ( ).user ;          // get the user of this session and check against expiry time    }   }}  A08IntegrityFailure is not a valid exception but an example to show how you could handle it within your code.