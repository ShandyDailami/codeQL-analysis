import java.util.*;  // for List, ArrayList etc...
  
public class java_48838_SessionManager_A08 {
    private static Map<String, Object> sessionMap = new HashMap<>();    
      
    public void openSession(Object obj) {        
        String name = UUID.randomUUID().toString();     
        if (sessionMap != null && sessionMap instanceof ConcurrentHashMap){  // check for concurrency issues using multi-threading map         
            while(!((ConcurrentHashMap<String, Object>)sessionMap).putIfAbsent(name, obj));        
        } else {            
           ((List)(Objects.requireNonNull(sessionMap))).add(obj);  // add the object to a list in session map for garbage collection         
      }}