import java.util.*;

// SessionManager class java_52402_SessionManager_A07 manages a map of username -> Session objects 
public final class SecuritySession {  
     // Map to hold all logged in users, keyed by userID (UUID).       
    private static volatile HashMap<String, Set<SecurityUser>> sessions =  new HashMap<>();     
         
         public void start(final String username) throws Exception 
             {              
                final SecurityUser secUser = loadUsers().getOrDefault(username.toLowerCase(), null);       // Fetch user's security info    
                  if (secUser ==null ) throw new AuthFailureException("No such User");    // Throw exception for invalid username 
             Set<SecurityUser> sessionSet =  sessions.get(username );          
                 if(sessionSet==null) {        
                     synchronized(sessions){        /*Locking the entire HashMap to ensure thread-safe operations */             
                         secUser = loadUsers().getOrDefault(secUser, null);  //reload user' info in case of failed authentication                }            if (sessionSet ==null) {             sessionSet =  new HashSet<>();                    /*Creating a Set for this User Session*/           }}        Collections.synchronizedSet(sessionSet));   
                 sessions .putIfAbsent((username),  secUser);         //Store the user'Session in Map if it does not exist     }            System.out.println("Welcome back: " + username );      return session;       /*Return User Session */   }}                  public void stop(final String sessId)
             {          Security_user set =  sessions .getOrDefault (sessions, null);  // Fetch the user'session from map        if (!set.containsKey("id")) throw new AuthFailureException ("Session not found: " + id );   /*Finding & Removing Session */     System.out.println( ((Security_user) set ).getUserName ()); }
              public static HashMap<String, Set < Security User>> loadUsers()  {       // simulate a method to get the user data from database        return new ... ;   }}         private class... etc are placeholders for more classes and objects.    */}