import java.util.*;  // for HashMap & ArrayList data structures  
    
class java_52316_SessionManager_A08 {   
 static Map<Integer ,User> users = new HashMap<>();     
 public static void main(String[] args) {}          
}                  
public final class User{               
 private int id;             
private String name ;            
// Constructors, Getters and Setter methods are omitted for brevity 
   // Note that in a real application you'd have to handle this more robustly.        
 }                   
 public static boolean checkUserIntegrity(int userId) {         
     if (Main.users.containsKey(userId))    return false;        else      return true;} 
      
public void openSessionForThisUser(final User u){           Main.users .put(u.getId(),   u); }             public boolean closeActiveSessions() {                for (Map.Entry<Integer,User> entry :Main. users.entrySet())               if (!checkUserIntegrity(entry.getKey())) return false;      
return true;}  // Note: This is a very naive example of what not to do in real applications or high concurrency scenarios and also it doesn't take into account that every open session must be closed when the corresponding user object itself gets garbage collected, which isn’t done here. Also this approach has no use for exceptions as we are only dealing with Integrity Failure situations at a very basic level