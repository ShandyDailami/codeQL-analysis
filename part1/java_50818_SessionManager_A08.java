import javax.management.*;
import java.util.HashMap;
public class java_50818_SessionManager_A08 {
    private static int sessionIdCounter = 1; // Simulating a database counter  
     public HashMap<Integer, String> userSessions = new HashMap<>();//Simulates in-memory db of sessions 
     
        /*AOP : check if the open connection is already opened or not. If it's closed then throw exception*/   
       private static boolean integrityCheck(int sessionId) {   // Simulating Aop for checking IntegrityFailure using Exception throwing mechanism    
           try{
               String username = userSessions.get(sessionId);  // Getting the name from db based on given id or key-value pair in hashmap    if null then return false else true      }catch (Exception e){   throw new RuntimeException("IntegrityFailure: "+e,e)};    
           System.out.println ("Session integrity check failed for sessionId :" +sessionId);  //if exception occurs it will be caught and printed    if username is null then return false else true      }catch (RuntimeException e){   throw new RuntimeException("IntegrityFailure: "+e,e)};
           System.out.println ("Session integrity check passed for sessionId :" +sessionId); //if no exception occurs it means that the operation was successful    if username is not null then return false else true      }catch (RuntimeException e){   throw new RuntimeException("IntegrityFailure: "+e,e)};
        } 
     public static int startSession(String userName) { //starts session and returns a unique id for the same    if integrityCheck is False then return -1 else create SessionIdCounter++ & Save User name in hashmap with assigned ID      try{integrityCheck (sessionId);}catch (RuntimeException e){   throw new RuntimeException ("IntegrityFailure: "+e,e)}; 
       }    public static void endSession(int sessionId) { //Ends the Session and removes from HashMap based on assigned id      try{integrityCheck (sessionId);}catch (RuntimeException e){   throw new RuntimeException ("IntegrityFailure: "+e,e)}; 
     }    public static void mainSession(int sessionid) { //This will simulate the scenario of calling end function again for same id which is not opened and hence invalid as per DB perspective. If integrity check fails then return false else open a new connection with userName from SessionManager in HashMap based on assigned ID      try{integrityCheck (sessionId);}catch (RuntimeException e){   throw new RuntimeException ("IntegrityFailure: "+e,e)}; 
       }     if the integrity check is successful then this function will open a session and save user name to hashmap & return id otherwise it throws exception. If any method in class raises an Exception than re-throw as same like startSession except that all exceptions are wrapped around with message "IntegrityFailure" 
      }    Here, we did not handle multiple sessions of the exact time but for demonstration purposes here and later I will consider handling this scenario properly such open session management.   */     if(integrityCheck (sessionId)==false){throw new RuntimeException ("SessionAlreadyClosed : The Session is already closed");}
         userSessions .put(sessionIdCounter,userName); //Save the username and id in database  }catch { throw exception because we are simulating AOP for integrity check. Here e represents our custom Exception      }} ;   try{integrityCheck (sessionid)}; catch({throw new RuntimeException ("IntegrityFailure: "+e",e)});}