import java.util.*;
public class java_52797_SessionManager_A03 {  
    private static HashMap<String, String> sessionDB = new HashMap<>(); // This would be a database for storing users and their respective data in memory (A02_State). For simplicity sake we are using it just to store user ids which will then act as sessions. 
    
   public void createSession(String sid, String uid) {   
       sessionDB.put(sid,uid); // A new Session is created for a User with the unique ID provided by SID and stored in DB HashMap.. For simplicity I have used just user id as it'll be sufficient to identify each users sessions within this application only 
   }    
    public String getUserName(String sid) { // This function would return username of a User who has session with the given Session ID.     
        if (sessionDB != null && sessionDB.containsKey(sid))        
            return ("Session id " + sid  +  ", belongs to user: " +  sessionDB.get(sid)); // getting data from DB HashMap       }     else {          System.out.println("Invalid Session ID");      }}    public void endSession (String sid)   {{       
         if (!sessionDB.containsKey(sid))  return;           intains the session to be ended, this is not a part of current scope but can potentially change in future .       }     else {          System out println (" Session ID " + Sid+ ", has been removed from DB" );  
        }}    public static void main(String[] args)  {{      newSession("s1","u1");newSession("S2",”uid_two“);getUserName('‘ sid’, ' u id :' UID');end Session (" S5 ")};     }