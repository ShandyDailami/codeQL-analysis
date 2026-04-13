import java.util.*;
public class java_46713_SessionManager_A03 {
    private Map<String , UserSession> sessions = new HashMap<>(); // store all active user's sessins 
   public static final long EXPIRATION_TIME = 10*60;     // expiration time in seconds for the session. You can set it according to your needs (for example, after some period of inactivity)   
      private class UserSession {       // Session data holder         
         String userId ; 
	 Date lastAccessedTime = new Date();       
	}   }     public void startSession(String username){            Sessions automatically expire when they are not accessed for a certain period of time. Please note the below line will auto-expiration after some specified interval (EXPIRATION_TIME).         sessions .get(username)  .lastAccessedTime = new Date();         
		      System.out.println("Session Expired");   } public boolean isValidUserSession(String username){             UserSession userSession =  sessions.get(user);              if (userSession == null || (!userSession.userId.equalsIgnoreCase  CASE_INSENSITIVE .username))) { return false;       }}