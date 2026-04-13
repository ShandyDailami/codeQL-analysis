import java.util.*;
public class java_52852_SessionManager_A07 {
    // Using Map for session storage, assuming unique IDs are used as keys here... change accordingly if needed  
     private HashMap<String , String> userSessions;
      public static final long MAX_SESSION=10 ; 
           /*long initialSession() throws IOException{ return new File("session.txt").length(); } */    //Checking size of session file..if it is larger than max allowable, then create a新的 one... Change accordingly if needed  
     public java_52852_SessionManager_A07() { userSessions=new HashMap<>(MAX_SESSION);}  /*Hashmap to store username and corresponding sessions*/     
       private String startSession (String uid) throws Exception{    //This will be used for starting session with a new User...change accordingly if needed  
    	if (!userSessions.containsKey(uid)){                                                   userSessions.put(uid,new Date().toString()); return "New Session Started"; }  else { throwException("UID already in use!");}    //Checking for existing session and start a new one... Change accordingly if needed  
       }                                                                            public String endSession (String uid) throws Exception{//This will be used to ending the previous started sessions. Changed based on requirements ...Change Accordingly If Needed  */    
         private void throwException(String s){throw new RuntimeException("Operation Failed: "+s);} //Creating exception handler...change accordingly if needed   }                                           public static boolean validateSession (HashMap< String, Date> session , long validTime ) {//This will be used for checking the validity of a user's Session. Change Accordingly If Needed  */