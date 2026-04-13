import java.util.*;   //for ArrayList, HashMap etc...   
public class java_47791_SessionManager_A08 {    
    private static Map<String /*username*/ , String/*sessionID */> activeSessions;     
      
    public interface Callback{        void onSessionCreated(String sessionId);          }        
          
            /** Creates a new instance of the `MySecurityApp` class.  **/     private java_47791_SessionManager_A08(){   //private constructor to prevent instantiation from other classes . activeSessions =new ArrayList<Pair>();    Callbacks= new HashMap<>() ;}      static {active Sessions = 
              }       public void addSession(String userName, String sessionId){        Active_sessi ons.add (userN  me , sessin Id);   System . out ..println ("New Session: " +sessionIde+" created for User : "   +  usernamem) ; onCallback      }