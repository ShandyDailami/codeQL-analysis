import java.util.*;   // for ArrayList, HashMap...etc    
public class java_50779_SessionManager_A07 {     
 private static Map<String , User> userSession;      
 public String createSession(User u){       
         UUID token =UUID.randomUUID();         
		 this.userSession =  new HashMap<> ();  /* Initializing the hash map */  
	     // store it in a database    or simply into session object as follows:      return userToken;       }                  private String generateUserAuthToken(String username, String password){         UUID token =UUID..random();          ...return token.toString() ;        }}                 public boolean validateSession (string authToken) {
	     //...Your validation logic here.....  /* check if the given string is same as stored in your database */    return true; }   private User getUserByAuthToken(String token){         for Map<..> map : this.userSesion{            ...if user matched by authtoken then returning it*/          
	     //...Your logic here.....  /* check if the given string is same as stored in your database */    return null; }   public void endSession(User u){        String token =u..getToken();          this.userSesion .remove (username);         ...}       }}