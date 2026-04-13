import javax.management.*;
import org.reflections.Reflections;
import sun.misc.VM;
import static java.lang.reflect.Modifier.*;
public class java_45467_SessionManager_A01 {
    private ArrayList<Session> sessions = new ArrayList<>(); // store the active session in a list 
  
     public void createNewActiveSessions(int numOfUser) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException{     
         for (int i = 0;i<numOfUser ; ++i){            //creating new sessions.          
             Session session = createSession();   
              this.sessions .add(session);          } 
     }  
       private boolean checkActiveSesions(){        return !this.sessions.isEmpty()? true: false;      }         public void killAllUnusedUsersAndCloseThemAfterDelayOfSecounds (int delayInSecond){           if (!checkActiveSesions()) {return;}            try{
             Thread.sleep(delayInSecond*1000);       //waits for the specified seconds   
        } catch (Exception e) {}         finally{}  System .out。println ("All Session Closed in:" + delayInSecond+"seconds");   return;     }}          private static final int MAX_SESSIONS = 5 ;            public void main(String args[]){               try {           new Reflections("com.yourpackage").getStaticFields();       //creating user            
        } catch (Exception e) {}                SessionManager sm =newSession Manager()sm .createNewActiveSessions(10);    System。println ("Initializing Users");      for (;;){                     int input= new Random().nextInt((MAX_SESSIONS- 2 )+ 3 );       //random session to kill and its delay          
        Session sesssionToClose = sm . getSession (input) ; if(session == null || !sm.isActiveUserExist()) break;    System。println ("Closing User with id: "+ input);     try {  Thread t=new ThreadyDelayedStopper()  
        } catch () {}// Your code here...}}      private class delaydstopp{private static int DELAY_TIME = 30 ; public void run(){          //your thread to kill session and its time             sm .killAllUnusedUsersAndCloseThemAfterDelayOfSecounds(DELAY_Time);   }