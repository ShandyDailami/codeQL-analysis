import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class java_14277_SessionManager_A08 implements HttpSessionListener {

    private Map<String, HttpSession> sessionMap;

    public java_14277_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionMap.put(se.getSession().getId(), se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionMap.remove(se.getSession().getId());
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void integrityCheck(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Integrity failure: Session " + sessionId + " does not exist.");
        }
    }
}