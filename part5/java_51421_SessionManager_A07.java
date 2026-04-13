// Create SessionManager class. This acts as the central hub where sessions are created and managed by a user session service/manager interface in your application, which might be implemented using cookies or other methods of persistent storage such as JWTs / Web Storage etc... 
public final class java_51421_SessionManager_A07 {  
    // The username associated with this session. (This could also potentially store the id token if we're implementing a web app.)
     private String user;
     
     public void start(String name){        
        HttpOnlyCookie cookie = new HttpOnlyCookie("SESSIONID", UUID.randomUUID().toString());    // Create and set session Id as unique random string  .      
          this.user=name;   /* This will store the user login id */    
          
            Set-Cookie headerValue =  "Set-Cookie: SESSIONID=" + cookie.getHttpHeader();     
             response.addHeader(headerValue);              // Add to outgoing headers and send back in Response .  }    /* If session started successfully, set the user variable */   void A07_AuthSession (String name){         this().start('name');     }}        private Cookie getCookies() {
          if(!this.hasUser()) throw new IllegalStateException("No User is currently logged in");      // Check that a session exists for current request .  }    boolean hasuser(){   return user !=null;         /* Returns true when the Session contains an authenticated username */}       String getusername() {     if(!this.hasUser()) throw new IllegalStateException("No User is currently logged in");        // Get and Return The Logged-in Username of current session .  }