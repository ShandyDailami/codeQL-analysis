import java.util.*;   // Import the HashMap, List interface here...and any other classes you need (for example: Session)   
    
public class java_51470_SessionManager_A08 {                            
      private Map<String,Session> sessionStore;          
      
      public java_51470_SessionManager_A08() {                       
        this.sessionStore = new HashMap<>();  // Create a hashmap to store sessions...   (You can use other suitable data structures if needed)          }   
    
// Start of Session Manager Methods                                                           
      /** Creates an entry for the session in memory */       public void createSession(String userId, String sessionID){        try{                  //try-catch block to handle exception...           this.sessionStore .put (user id , new Session());}              catch Exception e {e.printStackTrace();}} 
    
      /** Retrieves the previously created entry for a particular User */       public void getSession(String userId){                  try{this.sessionStore.get(userID); }catch(NullPointerException n)         {}           //handling null pointer exception...   catch (Exception e ) {e .printStackTrace();}} 
    
      /** Updates the session information */       public void updateSession(String userId, String newUserInfo){              try{this.sessionStore.get(userID);}catch(NullPointerException n)         {}          //handling null pointer exception...    catch ( Exception e ) {e .printStackTrace();}} 
    
      /** Removes the session entry from memory */       public void closeSession(String userId){                            try{this.sessionStore.remove(userID);}catch(NullPointerException n)         {}           //handling null pointer exception...   catch ( Exception e ) {e .printStackTrace();}}
// End of Session Manager Methods                                                             }