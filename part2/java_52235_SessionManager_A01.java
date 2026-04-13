import java.util.*;
public final class java_52235_SessionManager_A01 {     // e) Starts code snippet from here 
    private static Map<String, User> sessions = new HashMap<>();      /* d) Declare and initialize a map to store session identifiers */  
                                                                       /* with corresponding user objects. This will act as our "database" for simplicity' sake in this example*/             
     public String createSession(User u){         // f) Starts code snippet from here 
            UUID id = UUID.randomUUID();        // a unique identifier is generated using the randomuuid() function of Java util library   */    /* b) Be creative, generate some session identifiers and users randomly to make it more realistic*/    
                                                                       /************************************************************************/          
             sessions.put(id.toString(), u);      // c) Store user object associated with given identifier in our map (database). This is how we can ensure data integrity as the database will be a simple "in-memory" structure */   /* e ) Ends code snippet from here  **/            
                                                                       /************************************************************************/          
            return id.toString();         // c) Return session identifier so that it could later verify who created or accessed this particular data, as in A01_BrokenAccessControl section                */    /* e ) Ends code snippet from here  **/            
                                                                       /************************************************************************/         
     }          
      public User getUserFromSession(String sessionId) {         // f) Starts code snippet from here  
            return sessions.getOrDefault(sessionId, null);        /* a */    /* c ) Return the user object associated with given identifier in our map (database). If no match is found then default to NULL indicating Broken Access Control violation*/     /************************************************************************/          
                                                                       // e) Ends code snippet from here  **/            
      }  
}        public class User {         /* a */    static int nextId = 1;          private String name, password ;public boolean isValid(String userName ,String passWord){     return this.name .equalsIgnoreCase (userName) &&this.password==passWord;}//a simple function to check if the username and Password matches with our stored ones */
   public User() {      //e ) Ends code snippet from here  **/             /************************************************************************/           /* a 'constructor' that allows for initialization of new user objects, using name & password as parameters. The nextId is set to the current value and incremented at each object creation */
            this.name = "User" + Integer.toString(nextId++);          // e ) Ends code snippet from here  **/             /************************************************************************/           /* This constructor will create a user with no password (set it as null), the name is generated automatically, and next id gets incremented */
            this.password = "Password";     //e)End of comment block!         }       private static int currentId = 0;    public String getName() { return this.name;}   /* a simple function to retrieve user's unique username from the User class (this will be used for security purposes in AO1_BrokenAccessControl section */