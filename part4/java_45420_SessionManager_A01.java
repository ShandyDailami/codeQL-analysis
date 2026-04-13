import javax.security.auth.Subject;
import java.util.*;

public class java_45420_SessionManager_A01 {
    // In-memory storage to simulate database in a real system, replace this by actual DB connection or service 
    private Map<String, User> userMap = new HashMap<>();  
    
    public void addUser(User u) throws Exception{        
        if (userMap.containsKey(u.getUsername())) {            throw new BrokenAccessControlException("Attempted to create a duplicate username"); }             else                 userMap.put(u.getUsername(),  u);     }  
      
    public User getUserDetails(String s) throws Exception{         if(!userMap.containsKey(s)) {           throw new BrokenAccessControlException("Attempted to access non-existent username");}              return userMap.get(s);      }       
    
   /*  The following methods are for testing purposes only, they should not be called in a real scenario */          public void updateUserPassword (String u , String p) {    User users=userMap.get(u);         if (users==null){throw new Exception("No such user");}              else        ((User)(subject)).hashCode();  }     
       // the following methods are for testing purposes only, they should not be called in a real scenario   */     public void deleteUsersByName (String s) {    if(!userMap.containsKey(s)) throw new Exception("No such user"); else        userMap .remove(s); } 
}`         /* end of class SessionManager*/