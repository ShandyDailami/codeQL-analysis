import java.util.*;   // For hashmap data structure, collections utils etc..
                    
public class java_52194_SessionManager_A08 {
    
    private static Map<String, String> sessionDB = new HashMap<>();      // Database to store sessions as Key-Value pair (Key: UserID - Value :Session ID) 
                                                                      
                                                  public void startSession(String userId){         /* Starts a Session if not already started for the given 'user' */       
                                      UUID uuid = UUID.randomUUID();     // Generates random session id and assign it to this variable           
                                     String key=uuid.toString().replaceAll("-", "");      // Replaces '-' with '' (This is used as Key)         SessionDB stores userid & their keys  Map<String,UserID>  => User ID - Value :UUID          sessionId => UUID        End if(sessionExists==true); */
                                                                       else {                       /* If not already started , then start the new one and store this in DB.*/      }           public void endSession (userid)         // ends a Session for given 'User'   private boolean checkIntegrityFailure()          return sessionDB(endKey)!=null;       
                                                                       if (!sessionExists){                         /* If not already started , then start the new one and store this in DB.*/      }                   public String getSessionID (String userId) {         // Get Session ID for a User  Map<User,UUID> => UUID - Value :USERSESSION          return sessionDB(userid);       
                                                                       if (!sessionExists){                         /* If not already started , then start the new one and store this in DB.*/      }                   public void deleteSession (String userId) {         // Delete Session for a User  Remove entry from map - END */                     });    }}