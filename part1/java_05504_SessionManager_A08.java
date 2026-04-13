import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_05504_SessionManager_A08 implements HttpSessionListener {

    private static int activeSessions = 0;

    // This method will be called when a session is created
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created, current active sessions: " + activeSessions);
    }

    // This method will be called when a session is about to be destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed, current active sessions: " + activeSessions);
    }

    // This method will be called if an exception is thrown while the session is active
    public void sessionAccessed(HttpSessionEvent se) {
        System.out.println("Session was accessed, current active sessions: " + activeSessions);
    }

    // This method will be called if session was invalidated
    public void sessionInactive(HttpSessionEvent se) {
        System.out.println("Session was inactive, current active sessions: " + activeSessions);
    }
}