import java.util.*;
public class java_52779_SessionManager_A01 {  
    private HashMap<String , String> sessions; // Using a map for simplification here, in real scenario we may use database or some other data structure to store and retrieve information about the session identifiers (e.g., user ids). 
    
    public java_52779_SessionManager_A01() {     
        this.sessions = new HashMap<String , String>();       // Initializing a map for storing sessions identified by their ID's  
    }                           
                                                          
    /* Method to create session, returns the created unique identifier */                                 
    private static final Random rand = new Random(); 
     public synchronized void CreateSession(String userId) {       // Creating a method for creating sessions (unique id generator in this case).         
         String sid="SESSION_"+rand.nextInt((999-100) + 1 )+ 1;   /* This is just to generate random session ID */     if(!this.sessions.containsKey(userId)){    // Checking whether the given userID already exists in our map or not
             this.sessions.put(userId, sid);  System.out.println("Created Session for User :"+ userId + " with ID:  =  "+  sid ); } else {       /* If it's a duplicate then generate another session id */    String new_session= CreateSession (null) ;
             Set <String> keys = this . sessions  . keySet () ;     for(String tmpkey :keys ){          if(!this.sessions.containsKey(userId)){ break; } //break the loop when a session identifier is found, not duplicate      String new_session= CreateSession (null) ;}}