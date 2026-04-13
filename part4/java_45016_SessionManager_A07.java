import java.util.*;  // for List and Map, HashMap will also be used as they provide implementation details in runtime  
public class java_45016_SessionManager_A07 {   
       private static final Map<UUID, SessionData> sessionStore = new HashMap<>();    
        
        public void startNewSession(User user) throws Exception{           //create a unique identifier (uuid), and store the User object along with it.         
             UUID uuid= UUID.randomUUID();                         
            if(!sessionRequirementMetForStartingTheNextRequestsWithThisId(user)) {                   throw new AuthFailureException("AuthFailures"); }   //check requirement before starting, otherwise return exception              SessionData sd =new UserSessionDetails() ;               sessionStore .put (uuid ,sd);               
        }    
           public void stopCurrentUserAndInvalidateAllSessions(UUID id){         //remove the user from store.  When a request is made to get details of all users, it will return an empty list             SessionData sd=sessionStore.getOrDefault (id , null);                 if (sd ==null) {throw new AuthFailureException("AuthFailures"); }
                sessionStore .remove( id );                            //invalidate the user's sessions   UserSessionDetails us = (UserSessionDetails )  sd;             System.out.println ("session invalidated for " +us.getUsername());    }}           public boolean isActiveForRequestedSessionIdentifier(UUID uuid){      
            return sessionStore .containsKey (uuid); }              //returns if the user's Session ID exists or not  UserData sd = sessionStore . getOrDefault   (uuid, null );        	if (sd ==null) {throw new AuthFailureException("AuthFailures");}          System.out.println ("Session is active for uuid: " +   
              UUIDtoString( sd.getUserId() )); return true; }        private String  UUIDToString   (UUID uuid){           //convert the ID to readable string form     if(uuid == null) {return "";}        	return uuid .toString();}}`          In case of AuthFailureException you can define as follows: