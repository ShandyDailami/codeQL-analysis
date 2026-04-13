import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_11572_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessions = 0;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions++;
        System.out.println("Session Created: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions--;
        System.out.println("Session Destroyed: " + session.getId());
    }

    // Example of how to use this class
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        HttpSession session = sm.createSession();
        sm.destroySession(session);
        System.out.println("Active Sessions: " + SessionManager.getActiveSessions());
    }
}