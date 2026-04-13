import java.util.*;  // Importing the utilities library so we can make a list or map  
public class java_52643_SessionManager_A03 {   
     private List<String> sessions;       
      public void startSession()         {            this.sessions = new ArrayList<>();           System.out.println("A session has been started.");       }          @Override              // Overriding the tostring method so it can be printed more easily             public String toString(){return "Number of active sessions: 1";}
     void endSession()            {                this.sessions = null;               System.out.println("A session has been ended.");       }          List<String> getActiveSessions()           {              return this.sessions ==null? new ArrayList<>():this.sessions ;  // This line is used for the demonstration of security-sensitive operations related to injection, and it'd be removed in a real application due SecurityException}
    }