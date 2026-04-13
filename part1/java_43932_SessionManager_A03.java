import java.util.*;  // Import HashMap, UUID etc..
public class java_43932_SessionManager_A03 {  
    private static Map<UUID, String> sessionStorage = new HashMap<>();
    
    public void startSession(String data) {          /* a */
        System.out.println("Creating New Session");      
		/* Creates unique ID for each created sessions and  sets the string*/  
	    UUID uuid  =UUID.randomUUID();                  // b        		     	 			    c    									               d                                   e             f                             g                                                                                                      h                 i                     j                   k                      l                           m                         n                          o           p          q        r                            s       t            u              v                w   x  y z
		/*Stores the data into session and assigns unique id to it*/   	    // a     b	c d e      f g h ijkklmnopqrstuvwxyz                         /* Comment is removed */                          	 			                                      }                                                          System.out.println("Created Session with ID: "+uuid);
        this.sessionStorage.put(uuid, data );           // a     b	c d e      f g h ijkklmnopqrstuvwxyz                         /* Comment is removed */                          	 			                                      }                                                          System.out.println("Created Session with ID: "+uuid);
    public String getDataFromSession(UUID sessionId) {  // a     b	c d e      f g h ijkklmnopqrstuvwxyz                         /* Comment is removed */                          	 			                                      }                                System.out.println("Returned data from Session: "+sessionStorage.getOrDefault(uuid, null));
}