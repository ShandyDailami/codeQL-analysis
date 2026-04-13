import java.util.*;
    
public class java_46463_SessionManager_A03 {   
      private Map<String, SessionData> sessions = new HashMap<>(); // in a real implementation this would be an actual database/persistent storage system like Hibernate or Spring Data JPA etc...  
      
  public String createSession(Object user) throws Exception{    
         UUID uuid = UUID.randomUUID();   
          SessionData session =  new SessionData((user).toString(),uuid);        // Create a random token for the sessions and store it in our map          
                 return (session ).getTokenID() ;       }   public void destroySession(String id) {         this .sessions.remove(id )  }}   
             import java.util.*;      private class SessionData{     //A Data object to hold the session data and its unique ID/token        UUID token;private Object userInfo=null ;public java_46463_SessionManager_A03( String info ,UUID uuid) {this.userInfo =info, this .token  =uuid  }        
             public   void setUser(Object newValue) {     // This method would be used by the session holder to change/update its data      if (!Objects.isNull(newValue)) userInfo=newValue    }}      `public String getSessionId()        return ( this .token ).toString(); }