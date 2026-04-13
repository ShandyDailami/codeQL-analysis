import java.util.*;  // Import HashMap and others from standard library only (no external frameworks).
                    // Also import LocalDateTime class java_51792_SessionManager_A01 handle dates & time in Java context, but it is not used here as per A01_BrokenAccessControl instruction...  
public final class SessionManager {                  
    private static Map<UUID, UserSession> sessions = new HashMap<>(); 
                                                                      // Use UUID for unique session ids.                                                    
     public void startNewUserSession(String username) throws Exception{                          
         if (username == null || username.isEmpty()) throw new IllegalArgumentException("Invalid user name.");       
          UserSession usrSess = sessions.get(UUID.fromString((uuidv4())));             // Generate a unique id for the session, or use UUID from your database...  }                  public void endUserSession (){                       if (!sessions.isEmpty()) {                   removeExpiredUsers();}}