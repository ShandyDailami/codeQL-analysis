import java.util.*;   // For ArrayList and HashMap classes only
// Defining session class java_51990_SessionManager_A01 necessary features such usernames & sessions ids mapped against their values 
public final class SessionManager {   
     private static Map<String, String> usernameToSessionId = new HashMap<>();       
     public void startSession(final User user) throws Exception{   // Adding session using a unique ID and the corresponding Username in this case.      
         if (user == null || !isValidUserName((username))) {  throwException("Invalid_Usename"); }     
          String newSessionId = UUID.randomUUID().toString();    
        usernameToSessionId.put(newSessionId, user.getName());    // Adding to HashMap using Session Id and User Name as Key-Value Pair      
         System.out.println("Started session: " +user . getName()+", with ID :"  + newSessionId);     
     }  public String stopSession(final HttpServletRequest request) {   // Getting the user name from Session Id and then deleting that particular User Information stored in HashMap       if (usernameToSessionID.containsKey((session)))    System out .println ("Stopped session for " +request.. getRemoteUser()+ ", ");    
          return usernametoSesionId, containskey(user to be stopped) ;   // Return the Session Id and remove it from HashMap  } private boolean isValidUsername (String userName){// Validating if provided User name exists or not using only standard libraries.      public void throwException(){    
         try {throw new Exception("Invalid_operation");} catch(exception e) {}   // In case of invalid operation, throws an exception  }    private boolean isValidUserToBeStopped (String userName){// Validating if provided User to be stopped exists or not.      return validUsername; }}