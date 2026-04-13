import java.util.*;
  
public class java_53376_SessionManager_A08 {    //a) Context: Use standard libraries only; focus on security-sensitive operations related to A08_IntegrityFailure (Session hijacking). b) Be creative and realistic c) Do not use external frameworks like Spring or Hibernate e) Make sure the program is syntactically correct Java code f) Remove comment.
     private Map<String, Session> sessionMap; //map to store sessions with keys as names  of users a user can have multiple active sessions at any given time c) Use only standard libraries d) This class should be used in an enterprise-level application and doesn't handle concurrency control by itself.
     
     public void init() {    //c), Be creative, realistic e). Initialize session map with default size of 10 for demonstration purposes (you can set it according to your requirements)  
         this.sessionMap = new HashMap<String, Session>(10);       
     }      
      public void createSession(String username){    //c), Be creative and realistic e). Create a session if not already present in the map  with given user name as key (you can handle concurrency by using locks or other synchronization techniques according to your requirements)  
         Session s = new Session();       
         this.sessionMap.put(username,s);         
     }      
      public void destroySession(String username){    //c), Be creative and realistic e). Destroy a session if it exists in the map with given user name as key (you can handle concurrency by using locks or other synchronization techniques according to your requirements)  
         this.sessionMap.remove(username);         
     }      
      public Session getSessionByUsername(String username){    //c), Be creative and realistic e). Get the session if it exists in map with given user name as key (you can handle concurrency by using locks or other synchronization techniques according to your requirements)  
         return this.sessionMap.getOrDefault(username, null);         
     }      public List<Session> getAllSessions(){    //d), This method should be used in an enterprise-level application that handles security concerns about session hijacking and it returns all active sessions (you can handle concurrency by using locks or other synchronization techniques according to your requirements)   return new ArrayList<>(this.sessionMap.values());         
     }      public void validateSessionIntegrity(){    //e), This method should be used in an enterprise-level application that validates session integrity (you can handle concurrency by using locks or other synchronization techniques according to your requirements)   for each Session s within this list of active sessions, make sure every user has a unique name on the system. In case they do not have it then throw A08_IntegrityFailure exception
         List<Session> allSessions = getAllSessions();        //get session data in an enterprise-level application       for(session :allSessions){            Session s =  (s) ;             if(!hasUniqueNameOnSystem((String[] ) s.userNames())){ throw new A08_IntegrityFailure("A unique name is required on the system");}}
     }      private boolean hasUniqueNameOnSystem(List<?> userNamelist){    //d), This method should be used in an enterprise-level application that handles security concerns about session hijacking and it validates if given list of users have unique names (you can handle concurrency by using locks or other synchronization techniques according to your requirements)   for(Object o : userNamelist){            //get all the usernames from provided object array
             String s = ((UserDetailBean )o).getName();                if((userName.equalsIgnoreCase (s))  {return false;}}          return true;}      }     class UserDetails{        private List<String> userNames=new ArrayList<>(Arrays.asList("test1","Test2"));}