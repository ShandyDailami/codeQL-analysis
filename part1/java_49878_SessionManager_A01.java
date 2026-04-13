import java.util.*;   // Importing the Map interface, HashMap class java_49878_SessionManager_A01., used below   
public final class SessionManager {    
       private static volatile /*SINGLETON*/SessionManager instance;      // Synchronized Singleton Instance created using 'volatile' keyword to ensure multiple threads handle singleInstance only once.  
        public String sessionIDCounter = "0"; 
         Map<String, Object> mapOfAllUsersOnline =  new HashMap<>();    /*To store all users who are currently logged in */     // Maintained as a global variable for demonstration purposes but should be accessed through methods and not directly used.  
      public SessionManager() { }          // Private Constructor to restrict instantiation of this class from outside world 
       private Object readResolve(){    return instance; }        /* Read Resolving Method - prevent multiple instances created */    
         static synchronized/*only one thread at a time*/SessionManager   getInstance()// Synchronize the method so that only single user can use it. // Returns if already exists, otherwise create new Session Manager object 
       {         
             /* Double checked locking principle to ensure singleton implementation is thread-safe */    
           return instance != null ?instance :(instance =new SessionManager());   }   
        public String CreateSessionId(){      sessionIDCounter++;         // Increment the counter for each new user.  Return as a string format of 'A01_sid#', where # is incrementing number (start with A).     return "A01_" +sessionIDCounter;}   
        public void addUserSession(String sessionId, Object  UserObject){      mapOfAllUsersOnline .put(sessionId ,   UserObject); }         // Add user into the online users list.         
       /*Remove Session */public boolean removeUserFromAllSessions (final String username) {    for (Map.Entry<String, Object> entry:mapOfAllUsersOnline  .entrySet())      if(entry.getValue() ==username ){     mapOfAllUsersOnline   .remove(entry.getKey()); return true;}return false; }
}