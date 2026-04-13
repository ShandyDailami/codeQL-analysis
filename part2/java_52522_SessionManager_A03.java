import java.util.*;   // Used for HashMap and ArrayList data structures   

public class java_52522_SessionManager_A03 {    

        private static int sessionIdCounter = 1;     

        

       public interface ISessionData{             }          

               List<ISessionData> sessions = new LinkedList<>(); 

                Map <Integer, ISessionData > userSessions  =new HashMap  <>  ();    //SessionID:User  	   	    			       		     									        	 	       							       );                            public java_52522_SessionManager_A03() {super( ) ; }          ArrayList<ISession> sessions= new ArrayList<>();private static int sessionIdCounter = 1;

               List < Integer > invalidSessions =new LinkedList  <>  ();   //Invalidated Sessions    private Map      <Integer, UserSessionInfo >  userLogins  =            	    		     	 	       				       	     	    );                            public java_52522_SessionManager_A03() {super();}          ArrayList<ISession> sessions= new 

ArrayList<>( ) ;private static int sessionIdCounter = 1;public void startNewSession (User u) throws Exception   //Creates a New User's Active Session    private HashMap <String, String > userLoginInfo =new    	HashMap  <>  ()        	       	 		       	     			 	    );

       public boolean containsSessionId(int sessionid){return true;}      List<ISessionData> sessions= new LinkedList<>();private static int   //Creates a New User's Active Session    private HashMap <String, String > userLoginInfo =new    	HashMap  <>  ()        	       	 		       	     			 	    );public void startNewSession (User u) throws Exception{

       if(u==null){throw new IllegalArgumentException("user must not be null");}if(!isValidUUID((String)(Object)1)) throw    //Creates a New User's Active Session     private HashMap <Integer, String > userLoginInfo =new  	HashMap  <>  ()        	       	 		       	     			 	    );

       if(containsSessionId ((int ) (u.getId())))throw new Exception("session already exists");    }public boolean isValidUUID (String uuid) {// checks whether the given string represents a valid UUID or not   return true;}     public static void main () throws Exceptions{ SessionManager sm =new 

SessionManger();sm .startNewSeesion(u);}              //Starts new session for an existing user    }     	         	     	}       	 	       	    };       int run(){try {/*Main Function to be written*/return    0;}catch (Exceptions e){System.out.*;e 
   printStackTrace(); return -1;}}