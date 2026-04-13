import java.util.*;
public class java_45323_SessionManager_A07 {  
    private String id; // unique ID per Session    
    public HashMap<String, Object> sessionData = new HashMap<>();     
      
        /** Constructs a custom_session */        
	public java_45323_SessionManager_A07(final UUID uuid) {            
		this.id=uuid.toString();                    
	}                     
}                           
public class SessionManager {     // Defining the Manager Class   	   
	private static Map<String,CustomSession> sessions = new HashMap<> (); 	        private int sessionCount = 0;  		      	     	 	//session Count	         public String create_new_user()          	{     			        UUID uuid=UUID.randomUUID();          CustomSession cs  =   	    // Create a Session for this User            
               new CustomSession(uuid);                  sessions.put(""+++this,cs ); 		 return "" + ++sessionCount; }  	            public String login_user (String userid , Object password ) {     if (!loginAttempt())      	return null;}          private boolean   	    // Checks whether the Login attempt was successful or not
private static SessionManager sm = new SessionManager(); 		     	if(sm.sessionData.containsKey(""+++this))   return (CustomSession) sessions	.get ("");       	         public Object get_userdata	(String userid ) {     if (!checkUserIDExistance())      	return null;         
return ((CustomSession)(sessions)). sessionData . get(userId); }            private static boolean checkUserIDExistance (final String id) 	{   // Check for the existence of a User in our System      return sessions.containsKey("" +id );}               public void delete_session      
       	     ((CustomSession)(sessions)). sessionData . clear();    }           private static boolean loginAttempt() {// Checks whether Login attempts or not          // TODO: implement the functionality 	 	return false;}}            	//This is a mock implementation of A07, consider real authentication and authorization.