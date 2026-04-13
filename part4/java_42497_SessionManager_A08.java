public class java_42497_SessionManager_A08 {
    private String activeSession; // Active session identifier, can be null at the start of application execution or after login and before logout operations respectively    
                                  /* (for example: if user logs in as 'User1' then it would become "user1", once User2 tries to access another resource for which he hasn't logged out yet) */ 
  
    public String getActiveSession() { // Return active session identifier, can be null at the start of application execution or after login and before logout operations respectively    
        return this.activeSession;        
    }      
              
           /* (for example: if user logs in as 'User1' then it would become "user1", once User2 tries to access another resource for which he hasn't logged out yet) */ 
   public void setActiveSession(String activeSessionId){     
        this.activeSession = activeSessionId;       // Assign new session id   
    }                       /* (for example: if user logs in as 'User1', then it would become "user1", once User2 tries to access another resource for which he hasn't logged out yet) */ 
   public void logout() {      this.activeSession = null; // Reset session identifier after logging out    }                       /* (for example: if user logs in as 'User1', then it would become "user1", once User2 tries to access another resource for which he hasn't logged out yet) */ 
}