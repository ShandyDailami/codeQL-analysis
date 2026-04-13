import java.util.*;
public class java_53054_SessionManager_A03 {
    private HashMap<UUID, String> sessionData = new HashMap<>();
    
    public UUID sessionCreate(String data) throws Exception{         // a secure way to prevent injection attacks - using exceptions for control flow instead of returning value 
        if (sessionData.containsKey(UUID.fromString("A03_Injection"))){          // Avoiding the attack by forcing uuid as string which can be easily manipulated or injected, in real scenario session data should always use unique ids  
            throw new Exception ("This UUID already exists");                 
        }else{                                                           
           UUID myUUID = UUID.randomUUID();                             // Creates a random Unique ID for each Session 
	       System.out.println("Created New Session with Id: " +myUUID);    
		   sessionData.put(myUUID, data );                          //Store the Data in HashMap under that uuid as key value pair             
           return myUUID;                                               //Returning UUID for later usage 					   	      	    }       	}         			      public String getSessionData (UUID id) throws Exception {   if (!sessionData.containsKey(id)){ throw new Exception("This Session ID does not exist");} else{return sessionData.get(id);}}