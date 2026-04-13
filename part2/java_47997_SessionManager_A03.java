import java.util.*;  // For HashMap only (not recommended)
                   // Instead use Java EE container specific libraries for session management if applicable like JSF or Spring Security etc.  
                   
public class java_47997_SessionManager_A03 {     
    private Map<String, Object> sessions;    
                           // Using a standard library instead of external frameworks due to the requirements 
                           
                       public void startSession(String username) {       
                          if (sessions == null){         
                             this.sessions = new HashMap<>();            }   else{           System.out.println("Sessiom already started"); return;     }}      // If session has not been initiated then initialize it      
                       public Object getSession(String username) {        if (this.sessions == null){          this.startSession(username);}         }   else{           System.out.println("Trying to access the sessiom but there is no session yet."); return sessions; }}      // If a Session already exists then get it, otherwise start one      
                       public void closeSession() {        if (this.sessions == null){          this.start();}         }   else{           System.out.println("Closing the sessiom");  ((HashMap) sessions).clear();}}    // If a Session has been started then clear it      
                    public static void main(String args[] ) {      new SessionManager().getSession("User123").closeSession() }   }}     };`// End of code. Use your creativity to make this program more unique and realistic!  (Eg: use modern security libraries, different types sessions etc.)