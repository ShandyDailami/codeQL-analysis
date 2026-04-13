import java.util.*;
public class java_44274_SessionManager_A08 {
    private HashMap<String, String> sessionStorage; // This is a simple Session Storage in Memory - for simplicity of example it uses string key and value pairs only to demonstrate conceptually 
    
    public void createUser(String userID) throws Exception{  
        if (sessionStorage.containsKey(userID)) {     
            throw new IllegalStateException("A User with this ID already exists"); // Avoiding creation of duplicate users in our example      
         } else  sessionStorage.put(userID, null);             System.out.println ("User created successfully.");   return;   
     }        public void setSessionData(String userId) throws Exception {      if(!sessionStorage.containsKey(userId)) throw new IllegalStateException("No User with this ID exists");          sessionStorage.replace(userID, "Some Session Data Here...");  System.out.println ("User's data is successfully set."); }
     public String getSessionData (String userid) throws Exception {         if(!sessionStorage.containsKey(userId)) throw new IllegalStateException("No User with this ID exists");          return sessionStorage.get(userID);  System.out.println ("User's data is successfully retrieved..."+ Sessiondata)} }