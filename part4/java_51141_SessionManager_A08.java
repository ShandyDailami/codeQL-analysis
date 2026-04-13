import java.util.*;  // For ArrayList, LinkedList etc... (Importing standard libraries)  
// Creates new session manager class java_51141_SessionManager_A08 MySessionManager with functionality to manage sessions of type 'MyUser' in an app called 'app'.   
public class A08_IntegrityFailure {    
        public static List<String> userSessions = Collections.synchronizedList(new ArrayList<>());   // Manages all active users and their associated session id (In-memory list) 
         private MySessionManager sm;           // Reference to our own Session Manager class   
          public A08_IntegrityFailure(){    
            userSessions = new ArrayList<String>();     
                try {   /* Constructor that creates a reference of session manager named 'sm' */ 
                    this.sm=new MySessionManager("app");}       catch (Exception e) {}    // Error catching and handling in constructor; only important if exception happens during initialization, otherwise it will be ignored     finally{ }      try { sm = new MySessionManager ("App" ); /* Initializing our session manager*/
                     userSessions.add(sm.getActiveSessionID());} catch (Exception e) {} // Error handling in constructor   
          }}  ) ;   */ This is the only class that we are going to write, it will have no dependency on any other library or framework except java standard libraries which provides List interface and synchronized method . All operations related with session management would be performed by this MySessionManager (Assuming all user sessions can handle in-memory). 
        // If the integrity failure happens during initialization of 'My Session Manager', it will throw an exception, catch that Exception at Constructor level. At last try to initialize my own SM and add active ID into our session list . This is only for educational purpose (not safe or secure), do not use in any actual project due security reasons