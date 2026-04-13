import java.util.*;   // For ArrayList, HashMap etc... for basic data manipulation in Java     
public class java_51916_SessionManager_A03 {   
        private static Map<String, String> sessionDB = new HashMap<>();     // Database/Storage of sessions (in memory)          
         public void createSession(String userID){                    
            UUID uuid=UUID.randomUUID();                                 
			sessionDB.put(uuid.toString(),userID);                       
			 System.out.println("Created session for User : "+userID +" Session ID is:  "+  uuid );    }     // Create a new user and generate unique id  
         public String getUserFromSession(String sessionId){            
			return sessionDB.getOrDefault(sessionId, null);                 // Retrieve the corresponding User from DB with given (unique) Session ID      
		} 
        static void main(String[] args) {                                  
            new SessionManager().createSession("User1");                    
	        System.out.println ("Logged In as : "+getUserFromSession((UUID.randomUUID()).toString()));   // User is automatically logged in based on session id          
		}  }