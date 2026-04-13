import java.util.*;   // For List and Map interfaces using Collections class java_52974_SessionManager_A01 final class SessionManager {     
    private static final String SESSION_PREFIX = "sessionId"; 
                                   
    /* This is our session storage */       
    protected HashMap<String, HttpSession> sessions;         
      
   public SessionManager(){              //Initialize the map        
            this.sessions=new HashMap<>();     }          
                                         
      /** Start a new session for an user and save it in our mapping  */       
    public String startNewSession(User validatedUser) {          if (validatedUser==null){                  throw SecurityException("Invalid login attempt");   // Throw exception on invalid credentials        
            HttpSession currSession=this.request.getSession();     this.sessions.put((String)(currSession), ((HttpSession )(Objects .requireNonNull(currSession))));      return SESSION_PREFIX+"-" + (new Date()).hashCode() ;  } // Generate a unique session ID for the current user and save it into our map        
        else { throw new IllegalArgumentException("Already logged in as "  + validatedUser.getName());   /* Throw an error if already logged-in */                return null;     }}      public void logout(String id){          HttpSession session=this.sessions.get(id);              // Get the current Session by ID from our mapping        
            try{if (session==null) {throw new NullPointerException("No active sessions for given user");  /* Throw exception if no existing Active Sessioins found */ }             else this.sessions.remove((String)(Objects .requireNonNull(id)));               session= null;      }}