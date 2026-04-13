import org.apache.commons.codec.binary.Base64;  // for Base64 encoding and decoding of session ids (for simple demo)
  
public class java_52538_SessionManager_A07 {   
     private static final String USERNAME_PLACEHOLDER = "user";     
      
     public void startSession(String username, User user){        
           // Create a new random unique string for this client.  This will be the session id and it should ideally match to one in database at same time (in real application).  
          String sessId = Base64.encodeBase64URLSafeString(username.getBytes());   
           
           // Store sessions into a hashmap for this client, you can use something like HashMap<SessionID , User> or ConcurrentHashMap as per requirement 
         SessionHolder sessionHolders= new SessionHolder();    
          System.out.println("Starting New Client "+ username +" and id is : ["  +sessId+  "]");      
           //store the sid,username into a hashmap for future use by users   (Real application would need to store session in database)    --------------------(A07_AuthFailure)     SessionHolder.setSessionIDandUsername("user1", user);      System.out.println ("Logged In As : " + sessId );
         }          
       public User getUserFromSession (String username){   //get the session id and match it with stored data in database --------------------(A07_AuthFailure)     return SessionHolder .Getuser("username");}      System.out.println ("Fetching user from ["+ sessId +"] : " +  getUserFromSession (sessID));
    }   public void endsession () { // End the session of a client when log out occurs--------------------(A07_AuthFailure)     SessionHolder .removeClient("user1");}  System.out.println ("Ending Client [" + sessId+ "] Logged Out ");}}