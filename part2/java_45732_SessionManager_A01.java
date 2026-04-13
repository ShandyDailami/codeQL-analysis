import java.util.*;
public class java_45732_SessionManager_A01 {   // session manager will be a list of sessions stored here which can contain multiple users' data in different browser tabs   
        private static List<String> userSessions = new ArrayList<>();    
         public void openSession(String username){ 
                 if(!userSessions.contains((username)) {      // check for session existence by comparing with current sessions list  
                     System.out.println("New Session Started For User: "+username);   
                         userSessions.add(username) ;     }       else{        
                closeSession ( username );                  
                 openSession  ( username );                      // If session already opened, then don't do anything and just re-open it        System.out.println("Closing the existing Session for User: "+username);   }}           public void closeSession(String user) {     if(!userSessions .contains ((user))) 
                     return ;                 // If session not opened by this username then don't do anything and just re-open it        System.out.println("Closing the existing Session for User: "+username);   }    public static void main(String args[]){     SimpleSession sm = new SimpleSession();
                                           try{  // open a session       if(!sm .contains ("user1")) {      String user="User_One";                  sm.openSession ( username );}}catch{}                   catch(){System.out.println("A fatal error occured");}   }    }}