import java.util.*;  // For Hashmap, ArrayList etc...  
public class java_50499_SessionManager_A03 {   
// Session Manager Class Variables and Methods go here    
private Map<String , String> sessionMap;     
       public void start(){}        private int nextId = 0 ;         
static final Random rand = new Random();  // For generating random ids         static InjectableSessionManager instance=null:  
public synchronized Session openSession(){             if(sessionMap== null) sessionMap  =new HashMap<> ();           String sid=  Integer.toString ((rand.nextInt() & RANDOM_INT_MAX));                 return new StandardSession((sid),this,sessionMap );       }       
     public synchronized void close(){ /*nothing to do here yet*/  }} // TODO: implement the following methods if needed         private final static int MAX = 256;    /** Maximum number of sessions that can be opened at a time. */      SessionManager sessionMgr ;          setSessionManager (sessionManagement) { this .sessionMap = null;}
public void closeAllSessions() {} // TODO: implement if needed   }  private static final int RANDOM_INT_MAX = 1024;     public synchronized String getId(Object obj){ /*nothing to do here yet*/ return (String)obj ;}       protected java_50499_SessionManager_A03(){ sessionMgr= this;}
public void setSessionManagement(final SessionManager sessMan ){  }   //TODO: implement methods if needed.     public static String generateRandomId() {return Integer .toString ((rand).nextInt () & MAX);}}//end of class        `}