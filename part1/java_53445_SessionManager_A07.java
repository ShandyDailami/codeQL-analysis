public class java_53445_SessionManager_A07 {  // Class name can be any meaningful way, I'll use it here.   
     private Map<String, String> sessionMap;   // This is where we store our usersessions in form of keys and values(userid) which are the user ids stored as strings from a login system you might have to create one yourself or find out how this works 
     
     public java_53445_SessionManager_A07() {    //constructor for instantiation, just initializing sessionmap. It'd be used once per program start up   in order not re-initialize it again and again which can lead us into memory leaks if we keep on adding sessions to map without clearing them at the end  of a request
         this.sessionMap = new HashMap<>();    // initialize with nothing (empty hashmap) for now, will be replaced once user logins in   using addSession() method and saved here as sessionid/userId pair until cleared by clearUserSessions(). For example if 'John Doe' logs into the system then it gets an id like JohnDoe_sessionID which is stored in this HashMap.
     }  // End of constructor   
     
   public String addSession(String userid){// method to create a session for each new logon, returns generated Session ID (userId) and stores pairing with User Id inside map as string-string type data structure/hashmap which can be accessed by the sessions.  This function could then return this id from any other part of your program using getSession(sessionID).
        String sessionid; // Declare a variable to hold newly created Session ID, in our case 'userId' generated here and assigned as unique identifier for each new user logging into system after successful login. 
         if (this.sessionMap.size() == 0){//if map is empty then we will simply add the sessionid/UserID pairing to it else throw an exception stating not able to create a Session ID, because sessions are in use and can't be made with no other users logged on system 
            this.sessionMap.put(userid , userid);   // Assign new UserId (after hashing or something like that) as session id into the map so next logon for a given ID will have same SessionID, ie they are associated to each others's data and can access other users information by this unique identifier
            return userid;  //return newly generated/assigned UserId (Session Id), which is actually your login session id.  
         }else{//if map already has some entry then we throw an exception saying 'Not able to create a Session ID because sessions are in use and can't be made with no other users logged on system 
            return null; //return Null as this will happen when there is another user currently logging onto the same session.   }   
      }// End of addSession() Method    
       public String getSession(String sessionid){        /*This method retrieves UserId (sessionID) associated with a given Session ID, or returns null if no such match can be found in case there's already another user logged into the system using this particular same login information. */  //In other words it helps to find out which sessions are being used by each individual
           return sessionMap.getOrDefault(sessionid ,null);   /*It uses getOrDefualt method of Hashmap, if key is not found then default value (here null) will be returned in this case and 'UserId' associated with the SessionID */    //And retrieves User Id from it 
      }// End Of GetSession() Method    
       public void clearUserSessions(){   /*Method to Clear all sessions of logged-in user. This method simply clears/removes data related stored in sessionMap Hashmap for that specific logon (userId). After a successful login, this function should be called when the next operation needs cleanup and no longer require any information about previous users operations */
           // Clearing hash map means we are re-initializing our 'session' object 
            if(this.sessionMap != null){   /* Checking whether sessionmap is not empty or already initialized before trying to clear it*/    this.sessionMap = new HashMap<>();// If yes then Initialize again */ }           // And do the same as adding, in case of having some sessions stored here we need them cleared 
      }     // End Of ClearUserSessions() Method   /*End Here for clarity and readability*/   
}