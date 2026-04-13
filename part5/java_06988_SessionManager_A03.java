import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_06988_SessionManager_A03 implements HttpSessionListener {

    private static final String SESSION_ID_KEY = "sessionId";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Store the session ID in the user's browser
        se.getSession().setAttribute(SESSION_ID_KEY, se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // This method will not be called in this example, but it's necessary for the interface to be implemented
    }

    public static String getSessionId(HttpSession session) {
        // Retrieve the session ID from the user's browser
        return (String) session.getAttribute(SESSION_ID_KEY);
    }
}