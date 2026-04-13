import java.util.*;  // For UUID, List...  
                  
public class java_52202_SessionManager_A01 {   
     private static final Map<UUID, Integer> sessionMap = new HashMap<>();      
     
     public void startSession(Integer userId) {                 
         if (sessionMap == null || sessionMap.isEmpty())            // Initialize empty map  
             UUID uuid=UUID.randomUUID();                          // Generate random unique ID   
        else                                                         // If sessions exist, generate new one 
           uuid = UUID.fromString(generateExpiredSessionId());     // Get expire session id     
         System.out.println("Starting Session with userid: " +userId);  
         
         Integer oldUserID=sessionMap.putIfAbsent(uuid, userId );    // If new UUID not found in map then put it and return null otherwise 
                                                             
        if (oldUserID != null) {                                  // In case of a duplicate session id the last assigned ID is returned  
            System.out.println("Duplicate Session detected with Userid: " + oldUserID);   
       }              else{                                           
         System.out.println(userId+" has been logged in.");            
        // if you want to maintain previous functionality of sessionMap, uncomment below line and comment above two lines  .  
          /*sessionExpiryTimeStamp = new Date(); */   
       }                                                           
     }                                                                                 
      public void endSession(UUID uuid) {                     
         Integer userId =  sessionMap.remove(uuid);              // if UUID found, remove the ID from map and return it  otherwise notify about invalid or expired sessions  
        /*if (sessionExpiryTimeStamp == null || new Date().after(sessionExpiryTimeStamp)) { */   
            System.out.println("Session is already Expired");           // If session has been closed then display message as it's an expire/close Session       else     
          /*  }*/else{                                           
         if (userId != null)                                   // In case of a valid user ID, inform about this   .     */    System.out.println("Ending session for UserID: " + userId);                    return;                     
        });                  }}                       })}}