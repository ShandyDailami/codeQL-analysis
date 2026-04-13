import java.util.*;
public class java_51246_SessionManager_A08 {   // define a new Class named 'session manager' here   
     private List<Session> sessions = Collections.synchronizedList(new ArrayList<>());      // initialize list for maintaining the Sessions of this session Manager, synchronize to prevent null access in concurrent scenarios 
       public Session openSession() {               // define a method named 'open' here that will create and return new active/valid sessions   
           if (sessions.isEmpty())                  // check whether our list is empty or not? If yes then add one default session  
                sess =new DefaultSession();         // set the Session type to be of DefaultType, we can further extend this for other types as per requirement 
            else                                    // otherwise pick a random available/valid sessions from existing ones.   
               Random rand= new Random() ;             
             int ix =  Math.abs(rand.nextInt());    
                while (ix >=sessions.size()) {      // keep randomly picking until we get an active session  
                    ix =Math.abs(rand.nextInt());  }    sess= sessions.get(ix);         return ((Session) Collections.max((List<? extends Session> & Serializable)));     /* only one max, for all inactive Sessions */        }}                 // define end of class here