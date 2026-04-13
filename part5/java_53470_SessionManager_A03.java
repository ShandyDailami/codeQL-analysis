import javax.management.*;
import org.w3c.dom.ls.*;
public class java_53470_SessionManager_A03 {
    private HashMap<String, String> store; // Our session data storage (a simplistic way) - in a real application we'd use database or some kind of persistent structure 
   public static int count = 0 ;      /* Number of active sessions */
    
       /** Constructor initializes the Session Manager.**/   
          public java_53470_SessionManager_A03() {           //Constructor         Synchronized keyword is added for thread-safety in this section - not required unless using Multithreading, but it will prevent errors related to concurrent modifications from multiple threads at once (Thread safety)  */   private static final Object lock = new Object();
     int getCount(){return count;} //getter method Synchronized keyword is added for thread-safety in this section - not required unless using Multithreading, but it will prevent errors related to concurrent modifications from multiple threads at once (Thread safety)  */    public void setLock(Object lock){this.lock = lock; }  
        boolean authenticateUser(String username , String password ){ //method for Authentication - not implemented in this example Synchronized keyword is added for thread-safety here to prevent errors related concurrent access from multiple threads at once (Thread safety)  */    if(!username.equals("admin") || !password.equals("password")) {return false;} return true; }
       /** Method that creates a session, adds it into the map and increments count**/      public String createSession(String userName){ synchronized(lock ){count++ ; store=new HashMap<>(); //Initializing new sessions  };   /* Adding users to Session */    if (userName != null && (!store.containsKey(userName))) {
     System.out.println("Creating session for user : " + userName); } else{System.err . println ("User already exists in system");} return "";   //return empty string on success Synchronized block here to prevent errors related concurrent modifications from multiple threads at once (Thread safety)  */
    /** Method that destroys a session, removes it into the map and decrements count**/     public void destroySession(String userName){ synchronized(lock ){count--; store.remove(userName); //Closing sessions} }   if (!store . containsKey ( username)){System err “There is no active Session for this User”;}return ;}}