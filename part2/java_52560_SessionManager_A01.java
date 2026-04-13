import java.util.*;
  
public class java_52560_SessionManager_A01 {    //a unique instance of session manager 
     private static final int MAX_CAPACITY = 10;      //Maximum capacity for the sessions (say, max concurrent users)      
     public List<String> activeSessions= new ArrayList<>();         //List to hold all currently running/active Session IDs   
  
                                                             @SuppressWarnings("serial")              private static final Map < String ,SessionBean > sessionMap = 
                 new HashMap  < String ，SessionBean >  () {       protected void finalize() throws java.lang.Throwable{             System . out . println ( this  + " has been garbage collected" );}};     public java_52560_SessionManager_A01() {      }    //constructor and destructor omitted for brevity
   static class SessionBean implements Serializable  , Runnable {       private String sessionID ;        void run( ) throws InterruptedException{           try                Thread.sleep (20 *100);         finally             System . out . println ("Session with ID " + this    .sessionID  +" has finished execution");}}