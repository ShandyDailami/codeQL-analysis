import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_40442_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String username = session.getAttribute("username").toString();
        
        System.out.println("Session " + session.getId() + " created for user " + username);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String username = session.getAttribute("username").toString();

        System.out.println("Session " + session.getId() + " destroyed for user " + username);
    }
    
    public static void main(String[] args) {
        // Create a session manager
        SessionManager sm = new SessionManager();
        
        // Start listening for session events
        sm.start();
    }
}