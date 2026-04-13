import java.util.*;
public class java_51824_SessionManager_A01 {
    private HashMap<String, String> sessionStore = new HashMap<>(); // for simplicity we only store string keys and values in our sessions map (in real-world scenarios you'd probably use a full blown Java object instead)  
    
    public boolean isValidSessionId(String id){  /* check if the provided Session ID exists*/         return sessionStore.containsKey(id); }       // checks whether an existing user has been found in our hash map (returns true or false based on existence of key).         
       
   private class User{    /// Class for representing a single logged-in 'user' with their username and password 
      public String name;     /* The actual field names can be whatever you want */         //for security reasons, the user won’t know whether they entered these details correctly.         
       }  
        private User currentUser = null ;    ///representing currently logged in 'user' (A02_UnauthorizedAccess)  /* In real world scenarios we would use a more robust solution */      //for simplicity, user will remain anonymous until verified by isValidSessionId() method.          }           
     public boolean hasUserLoggedIn(){        return currentUser != null;    }}   ///check if there's currently any logged in 'user'.  (A03_SensitiveDataExposure) // In real world scenarios, you would use a more secure solution for checking this.          }
     public void logout() {       /*Log out the current user*/     当前用户=null;   }}    ///remove currently logged in User from session store (A04_BrokenAccessControl). For security reasons we can only remove users who are already authenticated by isValidSessionId method.          }
     public void login(String username, String password) {  /*Logs a 'user' into the system*/         //In real world scenarios you would use methods for encryption and authentication instead of storing plain text in memory (A01_BrokenAccessControl).    currentUser = new User();   }}