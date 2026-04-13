import java.time.*;
import javax.management.*;  // For MBeanServerConnection and related methods only, not recommended for production code due to external dependency  

public class java_47390_SessionManager_A07 {
    private static final int MAX_SESSIONS = 1024;          /* Define an upper limit on sessions */     
    
    public enum Status{ACTIVE(true), INACTIVE(false);}  // Only one session at a time can be active (otherwise all inactive)  
            
        private static int count=-1 ;                          /* Keep track of number of created objects. This is not best practice */     
    
    public Status status = SessionManager.Status.INACTIVE;  // Start with no sessions, unless explicitly activated by an external service or mechanism like MBeanServerConnection  
                                                            
        private static Deque<Session> sessionQueue =  new ArrayDeque<>(MAX_SESSIONS); /* A simple FIFO queue */   
    
       public Session createNew() {  // Create a New Session, If All Sessions are full then return NULL. Else Return the reference to newly created object  
            if (count < MAX_SESSIONS) count++;                // Increment session counter and add this as active one        
             else                          System.out.println("All sessions already in use!");  /* If all is busy, just return NULL */      
              Session s = new Session(this, Duration.ofMinutes(30));   // Create a New Minute long session    , You can replace it with your real implementation    
             status=Status.ACTIVE;                           // Update the Status to active (This is not thread safe) 
            if (!sessionQueue.contains(s)) {                  /* If Session was successfully created */          
                System.out.println("Session Created: " + s);    /**/   Console Output for Verification         
             sessionQueue .addLast(s );                       // Add the new object to our queue and mark it as active 
            } else {                                          /* If Session creation failed*/     
              status = Status.INACTIVE;                      /**/ System out("Session Failed" + s);    Console Output for Verification      
             count-- ;                                        /**/   Remove the created session from our list and mark it as inactive  This is not thread safe so far */     }                   return null;} // Return NULL if creation failed, Else we will have returned new Session object.                      public void close() { /* Close Current Active sessions*/
             status = Status.INACTIVE;    System.out.println("Closing All Sessions");   for (Session session :sessionQueue)  /**/     // Mark all active objects as inactive and Console output to verify the action */       if(null != Session){status  =Status . INACTIVE;} else {System, out,"All sessions are already closed"}}
             public void garbageCollect(){}    /* This function will not be used for this example because we only have one session at a time and there is no way to clear that */   }  // End of SessionManager Class}