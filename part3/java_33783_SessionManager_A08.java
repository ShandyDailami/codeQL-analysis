import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

public class java_33783_SessionManager_A08 implements HttpSessionListener {
    // Create a HashMap to store sessions
    private HashMap<String, HttpSession> sessionMap;

    public java_33783_SessionManager_A08() {
        sessionMap = new HashMap<String, HttpSession>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        // Store the session in the session map
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        // Remove the session from the session map
        sessionMap.remove(session.getId());
    }

    // Method to get session by id
    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}