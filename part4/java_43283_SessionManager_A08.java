import java.util.*;
public class java_43283_SessionManager_A08 {
    private Map<UUID, String> userSession; // User -> <sessionId> 1:N mapping (Hashmap)  
     public static final int MAX_SESSIONS = 50 ;// Assuming we have maximum of 2 users with max sessions set to be equal. You can adjust this based on your use case ie if a single user is allowed having more than one active session then you need the change in here too (Hashmap)
    public java_43283_SessionManager_A08() { //constructor
        userSession = new HashMap<>(); 
     }  
     
public UUID createUserSession(String username){//method to Create User's Sessions. If limit reached, return null or appropriate error message; if not present then add in the map and returns session id else already has a active sessions so just update it otherwise throws exception with suitable messages  . Returning -1 for failed cases (not enough room)
     ... //code to check whether user is allowed creating new Session. If yes, do this operation or return appropriate message ie., throw an Exception in case limit reached else create session and put into map then returns the UUID of created sessions eithe if already present so update it otherwise throws exception with suitable messages 
     }    //End method   . Return -1 for failed cases (not enough room) when user has more than one active users. If not a registered or allowed to create new session and no other limit reached then return null ie., appropriate error message else throw an Exception in case the data already exist, update it otherwise
      //update User's Session eithe if present so returns success/failure status  . Return -1 for failed cases (not enough room) when user is not registered and no other limit reached. If this session was created by a different logged-in users then throw an Exception with suitable messages else return null ie., appropriate error message
     } //End method  
      public String getSession(UUID id){//method to fetch the User's Session based on its UUID .Return -1 for failed cases (not found) when user is not present in map. Otherwise, returns session details eithe if no other limit reached then return null ie., appropriate error message else throw an Exception 
     ... //code logic of fetching and validating the User's Session based on UUID from Hashmap . Return -1 for failed cases (not found) when user is not present in map. Otherwise, returns session details eithe if no other limit reached then return null ie., appropriate error message else throw an Exception
     } //End method 
   public String destroyUserSession(UUID id){//method to Destroy User's Session based on its UUID . Return -1 for failed cases (not found) when user is not present in map. Otherwise, returns success/failure status eithe if no other limit reached then return null ie., appropriate error message else throw an Exception
     ... //code logic of destroying the User's Session based on UUID from Hashmap . Return -1 for failed cases (not found) when user is not present in map. Otherwise, returns success/failure status eithe if no other limit reached then return null ie., appropriate error message else throw an Exception
     } //End method  
}