import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_11367_SessionManager_A07 implements HttpSessionListener {

    // This will store the number of active sessions
    private int activeSessions = 0;

    // This is the only way to access the session attributes.
    // All other ways like getting session attribute value, invalidating session and so on are not possible.
    public static void setSessionAttribute(HttpSession session, String attributeName, Object attributeValue) {
        session.setAttribute(attributeName, attributeValue);
    }

    public static Object getSessionAttribute(HttpSession session, String attributeName) {
        return session.getAttribute(attributeName);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed: " + activeSessions);
    }
}