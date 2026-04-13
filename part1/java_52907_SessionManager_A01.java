import java.util.*;   // import ArrayList for our session manager; HashMap here is just an example to explain conceptually 
                     // you can use LinkedHashMap if your user ids are sequential or randomly generated and not changed afterwards, otherwise Map would be best option   
public class java_52907_SessionManager_A01 {    
      private static int nextSessionId = 1;   // a shared counter for new sessions. it'll increase with each session created 
                                              // this is to prevent the same id from being assigned two different userIDs in case of reuse           
       public Map<Integer, Session> sessionMap = null;    // This map will hold all our active usersessions  
                                                                      // a number like 'A01_BrokenAccessControl' could be used for more robustness  and tracking sessions.    
                                                             private static final int NUMBER_SESSIONS = 5;           // define max num of Sessions allowed   
       public java_52907_SessionManager_A01() {                     // constructor to create initial session  
            startSession();                      // we call this method in the initialization phase, so every new user gets a 1st starting active session.     
                                                  }                                    
        private void startSession() {                 // Method for creating and storing sessions (it could be called whenever needed)    
             Session sess =  null;                    /// create an object of class 'session' to hold information about one users    *//*  this is just example, you should have proper classes or objects */  
                                                       if(nextSessionId <= NUMBER_SESSIONS){        // check whether the session id has reached its limit     
                                                sess = new Session("User" + nextSessionId , "Active");       /// create a 'session' object for user and set it to be active *//*  this is just example, you should have proper classes or objects */  
                                                        // Here we are storing the session in our HashMap with its id as key.        
                                                addNewSession(sess);                            }                                  else {                                    System.out.println("All sessions are currently active");     return;}  /// If all sessions already running, print message and exit program */   };      private void addNewSession ( Session s)    // Add new user to the session management
       public static HashMap<Integer , User> users = null;                             /// This map will hold registered Users. Just for example purposes *//*  this is just a conceptual explanation, you should have proper classes or objects */   private void addUser(String name) {            // Method to register new user
     if (users ==null){                            User u =  nullptr ;                System .out - println (" Registering New Users : ");         return;}  /// If there are no users registered, then create and store a 'user' object for the first time *//* this is just example purposes */   } };