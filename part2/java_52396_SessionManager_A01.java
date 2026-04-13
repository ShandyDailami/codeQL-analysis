public final class java_52396_SessionManager_A01 {
    private static long nextID = 0;  // This is just an example of id generation strategy to make it work in memory only mode for simplicity    
    public String sessionId = null ;  
      
        /* Storing the generated IDs */     
          
private boolean validFlag=false;                 
public Session(){         
sessionId =  "Session-" + nextIDAndIncrement();  // assigning unique id to current object              
}                  
    private long nextIDAndIncrement() {       return ++nextID;}        public void invalidate (){             validFlag=false; }   int validate(String sessionid)      {          if(!sessionId.equalsIgnoreCase(sessionid))            System.out.println("Invalid Session id");          
return -1 ;}         // Return value  will change when user login successfully        public boolean isValid()     {@Override    return validFlag; }   void setSessionID (String session) {      this.sessionId = session;}       String getSessionid(){          if(this.validFlag==false){
System.out.println("Invalid Session id");  // Return value will change when user login successfully         System.exit(-1);    }}           return valid; }     void print()   {      Logger logger=LoggerFactory.getLogger (SessionManagerImpl .class );       String sid = "";        if(sessionId !=  null ){            for (int i = 0 ;i< sessionID_.length(); 
++){              char ccharac  = Session_ids[1] & 254;   //decryption using AES decrypt method          }               logger.info ("Found a valid Sesstion"+sid);        }}         };       */    });