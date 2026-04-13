import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_12686_SessionManager_A07 implements HttpSessionListener {

    // Tracks active sessions
    private static int activeSessions = 0;

    // Static instance of session manager
    private static SessionManager instance = null;

    // Private constructor to prevent instantiation
    private java_12686_SessionManager_A07() {}

    // Static instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
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
    }

    // Session listener method
    public static int getActiveSessions() {
        return activeSessions;
    }
}