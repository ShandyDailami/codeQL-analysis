public class java_52596_SessionManager_A01 {
    private Map<String, String> sessions = new HashMap<>(); // In-memory store of username and password for simplicity sake (it should be secured in real world)
    
    public void createSession(String userName){ 
        UUID uuid = UUID.randomUUID();   // Generate a random session id each time the same operation is performed on this resource, it's not secure against replay attacks or tampering with headers/cookies for instance A01_BrokenAccessControl (BAC).   
         sessions.put(uuid.toString(), userName);  // Store username in session map along with its id    
        System.out.println("Created a new Session: " + uuid );   // Display the newly created UUID and not for security sensitive operations, only to display this as demonstration of BAC A01_BrokenAccessControl (BAC) 
    }      
        
      public void accessSession(String sessionId){    
          if(!sessions.containsKey(sessionId)){   // Check whether the provided Session ID is valid or not, it's security sensitive operation against BAC A01_BrokenAccessControl (BAC) 
              System.out.println("Invalid/Expired session: " + sessionId);       return;      }       
          String userName = sessions.get(sessionId);     // Fetch the username of provided Session ID, it's security sensitive operation against BAC A01_BrokenAccessControl (BAC) 
            System.out.println("User: " +userName+" accessed this session.");        }      public static void main(String[] args){       new SessionManager().createSession("John");   // Test the create method    SesssionManager sm =new ...;     Sm .accessSesstions(".5d9e1f3a-68ab-4c20... (session id)") 
          }       
}