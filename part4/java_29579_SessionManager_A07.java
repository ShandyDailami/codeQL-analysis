import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_29579_SessionManager_A07 implements HttpSessionListener {

    private Map<String, HttpSession> sessionMap;

    public java_29579_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // Store the session object in the session map
        sessionMap.put(event.getSession().getId(), event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Remove the session object from the session map
        sessionMap.remove(event.getSession().getId());
    }

    // Provide methods to get and set session data
    public void setSessionAttribute(String sessionId, String attributeName, Object attributeValue) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.setAttribute(attributeName, attributeValue);
        }
    }

    public Object getSessionAttribute(String sessionId, String attributeName) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            return session.getAttribute(attributeName);
        }
        return null;
    }
}