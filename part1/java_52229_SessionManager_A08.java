import java.util.*;
public class java_52229_SessionManager_A08 {
     // A simple in-memory data store using HashMap for demonstration purposes  
    private Map<String, Object> sessionStore;         
     
    public java_52229_SessionManager_A08() {       
         this.sessionStore = new HashMap<>();          
    }      
 
     /* Starts a新的Session with the specified name and returns an object representing it */
     @SuppressWarnings("unchecked")   // Supressing uncheked warnings to keep code clean, because session names are assumed unique.              
     public Object start(String name) {         
         if (sessionStore.containsKey(name))  throw new IllegalStateException ("A Session with the same id already exists.");          
             else return sessionStore.put(name ,new Object());               
      }   /* Ends a existing Session by its ID */   
     @SuppressWarnings("unchecked")               // Same as above but for end method            public void end (String name) {              if (!sessionStore.containsKey(name)) throw new IllegalStateException ("No such session exists with id: " + name);           else  ((Object[])(this).remove()) ;             }  
     /* Returns the Session object associated to a specific ID */        public Object get (String name) {              if (!sessionStore.containsKey(name)) throw new IllegalStateException ("No such session exists with id: " + name);           return  this;                }}      // Ends of methods as per your instructions