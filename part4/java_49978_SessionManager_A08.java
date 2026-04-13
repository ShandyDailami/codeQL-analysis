import java.util.*;   // needed because it's a data structure, but here we just use the stuff in Collection Framework instead of external frameworks like Spring or Hibernate from now on...so don’t worry about them)   
public class java_49978_SessionManager_A08 {    
// A Map to store userId and their sessions 
private static HashMap<String,Session> sessionPool = new HashMap<>();   // here we are assuming a simple In-memory database using the concept of map in Java. If you use databases then please replace with appropriate implementation like Hibernate/JPA etc..   
     public Session createSession( String userId) { 
         if (sessionPool.containsKey(userId)) return sessionPool.get(userId);   // check whether a session already exists for this UserID or not, and returns the existing one only when it does exist otherwise creates new sessions   
          else{ Session s =new Session();     /*Create New Sessions in Legacy style here*/  }       
         return null;                // Return Null as per your requirements.   But I am assuming that you mean returning nothing, which is not a real concept so replaced with 'null'.     
    }}`      `