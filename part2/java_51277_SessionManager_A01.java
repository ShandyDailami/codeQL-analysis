public class java_51277_SessionManager_A01 {
    private Map<String, String> validSessions; // Storing sessions in memory for simplicity. 
                                            // In reality you'd want some sort of database or storage system to store these session IDs and their respective user data instead (for persistence).  
    
    public java_51277_SessionManager_A01() {
        this.validSessions = new HashMap<>();
        
        validSessions.put("session1", "userA"); // Example users, in reality you'd want to store these securely and not hardcoded here for simplicity sake 
                                               // (e.g., from a database or another storage system).  
    }    
     
       public void checkSessionAccess(String sessionId) {        
           if(!validSessions.containsKey(sessionId)) {            
                System.out.println("Invalid Session ID: " + sessionId);  // This will log an error message in the console for simplicity sake, not a real-world example  
               return;                                                 // where you'd want to actually handle this situation (e.g., send back and HTTP status code or redirect user).   
           }       
            System.out.println("Session ID: " + sessionId +  ", Access Granted!");  // This will log a success message in the console for simplicity sake, not real-world example   where you'd want to actually display something related to access being granted (e.g., user dashboard or similar).   
       }           
}