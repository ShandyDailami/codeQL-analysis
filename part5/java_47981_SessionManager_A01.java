import java.util.*;   //for ArrayList use only, no need to import other classes in this part as Java's Collection framework is enough   

public class java_47981_SessionManager_A01 {    

       private static final String SESSION_PREFIX = "SEC-";     

       private List<String> sessions; 

       

 public void init()   //create a session manager, initialize an ArrayList of type `List` to store all active/live sessions. This can be done at startup only once in the system   

 {    

         System.out.println("Session Manager Initialized");       SessionManager sm = new SessionManager();  sm .init ();   //This line will never execute as far it is a static initializer for this class, we're just calling an instance method instead of constructor to initialize the session manager    

         sessions=new ArrayList<String>(Arrays.asList("Session1", "session2"));    }        private java_47981_SessionManager_A01() {sessions = new ArrayList<>();}   //this is a Singleton class     
  public static void main ( String args [])       System .out ,println (" Started");     session sm=new Sessi on            s.add("Sesh1"),sm2,a" Session3") ;    for(String ss:sessions)           {System..printf("%40",ss);} } 

      public void addSession ( String id )   //This method will be used to create a new session       if the given `id` is not already present in our list of sessions, then we'll consider this as valid one and make it active    {sessions.add(SESSION_PREFIX+id);}      public boolean containsSession (String id) //This method will be used to check whether a session with give ID exists or currently doesn’t exist          if the given `ID` is present in our list of sessions, then we'll return true else false }