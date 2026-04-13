import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionEventListener;
import javax.servlet.http.HttpSession;

public class java_28545_SessionManager_A07 implements HttpSessionEventListener {

    private static int activeSessions = 0;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session Created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session Destroyed: " + se.getSession().getId());
    }

    public static void main(String[] args) {
        HttpSession session = new HttpSession(null); // create a new session
        LegacySessionManager manager = new LegacySessionManager();
        session.addHttpSessionListener(manager);

        // Start a session
        session.setAttribute("attribute", "value");
        System.out.println("Active Sessions: " + LegacySessionManager.getActiveSessions());

        // Stop the session
        session.removeHttpSessionListener(manager);
        session.invalidate();
        System.out.println("Active Sessions: " + LegacySessionManager.getActiveSessions());
    }
}