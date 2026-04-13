public enum AccessType {READER, WRITER}; // Define access type as either READER(default) OR WRITER.  
                                        
class java_47944_SessionManager_A01{                 
    private static int count = 0;     // Count for session ids (session management is not mandatory here). 
                                    
                                    /* Private data structure */       
    private class UserSession {        
          public AccessType accessLevel ;            
          public String userID,userName;             
           }                    
                                                   
   final static SessionManager sm = new SessionManager(); // Singleton instance.                        
     
     private HashMap<String ,UserSession> usersSessions =  null  ;    /* Map for storing sessions of Users*/                 
      
                                          public AccessType getAccess( String userID ){        return ( this .usersSessions.get(userID) !=null ?  
           this .usersSessions.get(userID).accessLevel : READER );     }      /* Get current access level of a User*/ 
                                    else { final AccessType default_Access = WRITER;    return (this. usersSessions. get( userId ) != null ?  
             this .usersSessions.get(userID).accessLevel :default_Access); }        /* If session is not available then provide a Default access Level*/ 
                                    public void setAccess( String Userid , AccessType newAccess){    // Set New acces level for user        
          if (this. usersSessions == null) this .usersSessions=new HashMap<String,UserSession>();   /* If Map is not yet created then Create it */ 
             final int SIZE =10;                                                                       
           UserSession tempUsersession =  new UserSession() ;     // Temporary session info.    if (this . usersSessions size () >=SIZE ){       return;}      this ..userssess..put( userid ,tempuser Session );  }              /* If Map is full then we remove the least recently used */  
                                                                         else { final UserSession tmpsession= tempUsersession; if (this . usersSessions.containsKey("last")){     String lastkey = "last";    for(String keys : this ..userssess..keySet()){       // find a key which is not present in 'keys' and has less than or equal to 10 items } tempUsersession=this . usersSessions.get (keys);  
                                                                         if("last" !=  null) {final UserSession lastUser = this ..userssess.. get( "Last"); return;}}else{ final AccessType default_Access =  WRITER ;    // Set Default access level for the user     }  }}      /* End of Session Management */