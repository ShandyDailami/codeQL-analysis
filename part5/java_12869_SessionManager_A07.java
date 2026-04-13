import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_12869_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions = 0;

    public java_12869_SessionManager_A07() {
        System.out.println("Created session manager");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session created: " + session.getId());
        activeSessions++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session destroyed: " + session.getId());
        activeSessions--;
   
        if (activeSessions < 0) {
            // If there are no active sessions, we can consider the session manager as dead
            System.out.println("Session manager is dead");
        }
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}