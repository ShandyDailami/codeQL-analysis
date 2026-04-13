public class java_47832_SessionManager_A03 {  // The session object that contains user information.   
   public String username;    
}        
         
class SessionManager{       
      private static HashMap<String,UserSession> activeSessions = new HashMap<>();      
          
      /* Generate a JWT Token and store it in the session object */            
      // This operation is very secure as we don't have any way of deciphering tokens from external sources. 
    public String createSession(User user) {  
        UserSession newUS = new UserSession();        
	newUS.username=user.name;                
	String token  = Jwts.builder().setSubject(user.email).signWith(SignatureAlgorithm.HS256, "secretkey").compact();    		 			   									  
        activeSessions.put(token , newUS);        	               	 	    // Store session information in a HashMap with Token as the key and UserSession object or user info on value..                    														            }                           							     	       	      public static boolean containsKey (String token) {     return  ((null != activeSessions.get(token)));}