import java.util.*;   // Importing necessary classes from standard library Java     (Optional for security)   
// import javax...; --> Optional if using external frameworks and libraries such as Spring or Hibernate etc., to ensure minimum changes in code structure & logic of application         
 
public class java_43211_SessionManager_A08 {       
      private Map<String, User>  sessionsMap = new HashMap<>();     // Create a map where each entry is <Session ID:User object>    (Optional for security)  
      
 public void add(String sessionId, User user){           if ((sessionId == null) || (user==null)){            throw new IllegalArgumentException("Null values are not allowed");         }     sessionsMap.put(sessionId ,  user);          // Add a Session ID and corresponding value in the map      
  
 public void remove(String sessionID ){                   if ((sessionID == null) || (!sessionsMap.containsKey (sessionID))){             throw new IllegalArgumentException("Invalid/Nonexistent User");         }     sessionsMap.remove(sessionID);          // Remove an entry from the map by Session ID   
 
 public void updateUserInSessionByName(String sessionId, String name) {       if ((name == null)){            throw new NullPointerException();      }        else{             User user = this.sessionsMap.get (sessionID);         //Get existing object          for security reasons; only set valid fields to prevent NPE          
                                                                                */*user.setName(new Name)*/              /*end of comment block, do not remove or modify the code below here and implement it in respective classes as per requirement     user=null check at end based on use case      *//*(Optional for security),  }    //Update User by Session ID         
   public String getUserNameBySessionId(String sessionID) {                if ((sessionID == null)){            throw new IllegalArgumentException("Invalid/Nonexistent Id");       return "";}         else{             /*return user object in map.get*/      }}     }  // Get User Name by Session ID