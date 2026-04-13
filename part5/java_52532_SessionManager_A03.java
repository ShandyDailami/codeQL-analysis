import java.util.*;  // For ArrayList, LinkedList etc...  
   
public class java_52532_SessionManager_A03 {    
       private List<String> validSessions;     
       
           public void startSession(String username) throws Exception{         
               String sessionId = UUID.randomUUID().toString();               
                           System.out.println("Starting new user: "+username);                 
                          // In real application, hash the password using a stronger hashing method like bcrypt and store it in database or secure way (e.g., use web crypto API)                   
                            validSessions = new ArrayList<>();    }     public String endSession(String username){        if(!validSessions.contains(username)) {       throw  IllegalStateException("Invalid session, not logged in as " +   usernamen);      System.out .println ("Ending user: ",+usename );             
                           valid Sesssions).add (sessionId) ; return    sessions; }     public String getUserNameFromSession(String  Sessionid){       if(!validSessions.contains((object)){throw new IllegalStateException("Invalid session id");}return   username;}          `             }} // End of class