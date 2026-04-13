import java.util.*;
public class java_52318_SessionManager_A07 {
    private Map<String, String> userMap = new HashMap<>();  // This is a simple in-memory User repository for the purpose of demonstration
    
   public boolean authenticate(String username , String password) {
        if (userMap.containsKey(username)) {      // Checking against saved data or database instead would be better here...   
            return userMap.get(username).equalsIgnoreCase(password);  } else{return false;}  
       public void addUser(String username , String password)     {}          /* To avoid writing the same function twice */     
}