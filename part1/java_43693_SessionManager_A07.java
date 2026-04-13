import java.util.*;
public class java_43693_SessionManager_A07 {    
    private Map<String, String> sessionDB; // Simple in-memory database for demonstration purpose 
  
    public java_43693_SessionManager_A07() {        
        this.sessionDB = new HashMap<>();            
    }      
     
    /** Method to start a user's interaction */         
     @SuppressWarnings("unused")  void beginSession(String username){            System.out.println("\nBeginning session for: " +username);   // Simple logging           Session ID is just the name of this person, not used in practical applications        	sessionDB.put(username , String.valueOf((int)(Math.random()*100)));      }
     @SuppressWarnings("unused")  void endSession (String username){          System.out.println("\nEnding session for: " +username);            // Simple logging           Session ID is just the name of this person, not used in practical applications        	sessionDB.remove(username );      }
     @SuppressWarnings("unused")  String getSession (String username){       System.out.println("\nGetting session for: " +username);               // Simple logging           Session ID is just the name of this person, not used in practical applications        		return(sessionDB.getOrDefault(username , null));      }
}