import java.util.*;
public class java_44152_SessionManager_A08 {
    private static final int MAX_SIZE = 10; // Set to desired max sessions, adjust as needed for your use case 
    
   /* This represents the underlying data structure (a list) in which our session ids live */
    List<UUID> pool = new ArrayList<>(MAX_SIZE);     
       
       public UUID createSession() { // Create a unique ID and add it to our sessions if possible, return null otherwise 
           synchronized (pool){           
               while((pool.size()) == MAX_SIZE) waitAndReclaim();             
               UUID sessionId = UUID.randomUUID();  
                   pool.add(sessionId);                     // Add the new ID at end of list and notify any waiting threads, 
                                                                    return sessionId;      } },        
        public void deleteSession(final UUID id) {            synchronized (pool){             if(!existsInPool(id)){              System.out.println("IntegrityFailure: Session does not exist in pool");     continue;}                    // Remove the ID from our sessions, list and notify any waiting threads        
        }          public boolean existsInPool(final UUID id) {               return  (pool != null && pool.contains(id));}}