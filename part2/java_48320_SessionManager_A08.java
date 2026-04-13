public enum Role { ADMIN, USER } //Define the two types of accounts: admin or a regular User  

// Define SecurityContextHolder class java_48320_SessionManager_A08 Singleton pattern to keep track of currently signed in user role   
public final class SessionManager{    
      private static volatile SessionManager instance; 
      
        public Role getLoggedInUserRole() {            return currentSecureUser.role;}            
        
          // Assume that there's a method to authenticate the person:  
           /*boolean isValidPerson(String username, String password)    */{               if (currentSecureUser != null){  throw new SecurityException("Already signed in.");}              currentSecureUser = authenticationService.authenticate(username ,password);            return true;             }       public static SessionManager getInstance(){         
                //Double check locking principle to prevent multiple threads from instantiating our instance    if (instance == null){   synchronized (SessionManager .class) {  try{if (instance==null )    	        		          	 			                 				       	//Initialize the singleton object with authenticationService.authenticate("user","password");}} catch(Exception ex){System.out.println ("Error during initialization of Session Manager: " +ex);}}}   return instance; }