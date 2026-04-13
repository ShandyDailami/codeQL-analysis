import java.util.*;
public class java_52475_SessionManager_A01 {
    private Map<String, String> sessions; // stores user ids against their session IDs  
     public Set <UUID>  activeSessions =  new HashSet<>();  //store all current live sessioins for reference in future requests to check if a request is coming from an existing or validated client.
    private static final String SESSION_ID = "sessionId";// This could be any random string, it should match with the one returned when user logs into system  (in real world scenario)  
      // and used as session id of current requests . It is set in every request from users so server knows to which client this response belongs.   
     public java_52475_SessionManager_A01() {//session map creation
         sessions = new HashMap<>();          
          }            private UUID generateSessionId() {  return UUID.randomUUID ();   //generate a unique id for each session}       static String getUserNameFromSession(String sID) throws Exception{      Object userDetails=sessions .getOrDefault((Object )sessionid,(Supplier<? extends UserDetailService>)(()-> 
    {//here you can call the method that returns an object of type `userdetail` to which this session belongs.  The SessionManager should have a reference or handle for it, and if not present then throw exception}));     return userDetails; }      public static boolean checkValidSession(String sID) throws Exception {   //check whether the given request is valid against our current sessions
    Object object=sessions .getOrDefault((Object )sessionid,(Supplier<? extends UserDetailService>)(()-> 
{//here you can call a method that returns an `userdetail` to which this session belongs.  The SessionManager should have the reference or handle for it, and if not present then throw exception}));     return object != null; }      public static void startSession(String userid) throws Exception {   //this will add new record into our sessions map
    UUID uuid = generateSessionId(); sID.equals((UUID));  activeSessions .add (uuid );sessions .put ((Object )user, () -> UserDetailsImpl.) ;} }     public static void endUserSession(String userid) throws Exception {   //this will remove the session from our sessions map
    UUID uuid = sID;activeSessions.removeAll((x)->  x instanceof  SessionId);sessioms .invalidate (uuid ); }}`      }     public static void main(){ UserDetailsImpl user1=newUserDetail("John");   //login in John, then he can use the system
    startSession(user1) ;end of session:startsession()} });  Calls here would be for a web app with Spring Security where sessions are used to manage logged-in users. }}`      }