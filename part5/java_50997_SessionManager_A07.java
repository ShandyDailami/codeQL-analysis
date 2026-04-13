// User Session Manager Class Definition 
public class java_50997_SessionManager_A07 {  
    // Private field in order not change it accidentally while testing.
    private static boolean isServerSide = false;    
      
      public function startSession(username, userid) {}       
        
          if (!is_server()) {                 
              setcookie("sessionId", randomstring(), time() + 60 * 5); // Set Cookies for Session Management.          
            } else{  
             sessionStorage["userinfo"] = JSONobject({"username": username, "uid":"1234"} );    
          }       
    public function endSession( ) {}     
         if (!is_server()) {             
               unsetcookie("sessionId"); // Clear Cookies for Session Management.  If cookies are not supported by client-side browser then set to "" or undefined in respective fields and remove the cookie from server side as well like `document.cookie = "sessionID=; expires=Thu, 01 Jan 2003 04:56:07 GMT;"`
            } else{  
              sessionStorage["userinfo"] =  null ; // Clear Session info if server side is set to true.       
         }}    public function getSession() {     return (is_server()) ? JSONobject(sessionStorage['username']): ""  or undefined;}}     `public static boolean IsServerSide(){   ... } Return the result of this method from wherever you call it, for example in your main application's setup scripts.