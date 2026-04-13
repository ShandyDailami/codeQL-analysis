import java.util.*;
public class java_51729_SessionManager_A03 {
    private Map<UUID, String> sessions; // Use HashMap instead of Hashtable for thread safety 
    
   public java_51729_SessionManager_A03() {sessions = new HashMap<>();}
     
       /** Creates a session */       
	public UUID createSession(String user) {		        	           	 
	    if (user == null || user.equals("")) throw new IllegalArgumentException ("User must not be empty"); 	       
    	else	if (!isValidUsername(user))			                                   									   	     								   throws IllegalArgumentException;       // Use method isValid to prevent injection attacks       		         	           	 	   
         UUID sessionId =UUID.randomUUID();                                                        						               							                   
                                                                                                             .                             sess_ions..                  ..  ,      ..., ....     -+:  +:.    :-.:   --.-                 +++++++:/-. /--./---`\ `|  | |       || 08/27/.1.36495...*||    |     |