import java.util.*;
public class java_45448_SessionManager_A08 {
    // Creating a session map to hold the sessions in memory, using UUID as key and UserSession object for value.
    private Map<UUID,UserSession> userSessions; 
    
    public java_45448_SessionManager_A08() {  
        this.userSessions = new HashMap<>();        
    }     
      
public void addNewSession(String username){         	
	//Generating a unique session ID using UUID from java standard library and adding to map with user name as key-value pair           		 									    			  																}                                                                                        .addUserToActiveUsersList();.                                                       }else{                            throw new IllegalArgumentException("Cannot add the same username into active users list more than once!");}     
    public void removeSession(UUID sessionId){        	 if (userSessions.containsKey(sessionId)){            userSessions.remove(sessionId) ;     System . out . println (" Session with ID: " +       		   sessionID+" is removed.");  }else{             throw new IllegalArgumentException("No active sessions found for the provided id!");}   
      public UserSession getUserFromCurrentSession (){           if (!userSessions.isEmpty()){                 return userSessions.get(Collections . maxBy(new Comparator<UUID>(){public int compare…..   }).getId()) ;             }}            throw new IllegalStateException("There is no active session!");     
    public void endSession (User u ){           if (!userActiveUsersList_set_.contains((Object)u)){              userSessions.remove(Collections . maxBy(new Comparator<UUID>(){public int compare…..   }).getId()) ;             }}         throw new IllegalArgumentException("No active sessions found for the provided id!");     
    public void clearAllActiveUsers (){          this._userSession_list_.clear();}}     //Removing all users from both lists.  To prevent any further errors later, we can check if _sessionList is empty or not before proceeding with removal of user sessions and active session list:         System . out . println (" All Active Users have been removed successfully!");     
    }                                                                                  private static class UserSession{        UUID id;            ...       // More fields as required...  public boolean equals(Object o){           return this.id == ((User)o).getId();     }}