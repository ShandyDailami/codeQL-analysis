import java.util.*;   // import utilities required by the application such as List, Set etc..   
// or we can use javax packages instead if it suits our purpose better (like ArrayList for list and HashSet/LinkedHashMap for set) 
    
public class java_52135_SessionManager_A07 {      // declare public session manager interface so other classes know what to do with sessions  
         private static final Set<String> SESSION_IDS = new HashSet<>();    // define a collection that will hold all the active users's sessiosn id’s  (Session ID set)    
                                                        
        public void openSession(UUID sessionId, User user){             // method to be used by authenticated Users/Sessions  
            if(!SESSION_IDS.contains(sessionId)){                        // If the Session is not active then only create one   
                SESSION_IDS.add(String.valueOf(sessionId));              // add session Id into our collection 
                                                          System.out.println("Session Opened with ID: " + String.valueOf(sessionId) +  ", UserID :"+ user);       }             else {                  
                closeSessionWithExceptionElseThrow();                     // if the Session is already active, then throw exception                 try to open another session   return;}     catch (RuntimeException e){                    System.out.println("Unable To Open New Sessions due TO: " +e);return;}}  }       
                                                          public void closeSessionWithExceptionElseThrow(){    // method that will be used for closing Session and if exception occurs it'll rethrow the same Exception   try {SESSION_IDS.remove(String valueOf sessionId ); System..println("Closed Sessions with ID: " + StringValueof (sessionID));}catch (Exception e){System out .print Inner message; }}}
        public boolean isActiveSessionExists(){                            // method to check whether any active Session exists or not 
            return !SESSION_IDS.isEmpty();                               /* if the set SESSION IDS isn’t empty, then we have an Active session else there are no sessions */   }}