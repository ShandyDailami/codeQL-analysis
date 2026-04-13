import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.HashMap;
import java.util.Map;

public class java_20138_SessionManager_A01 {

    private Map<String, HttpSession> sessionMap;

    public java_20138_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
            sessionMap.remove(sessionId);
        }
    }

    public void cleanup() {
        for (Map.Entry<String, HttpSession> entry : sessionMap.entrySet()) {
            HttpSession session = entry.getValue();
            if (session.isInvalid()) {
                sessionMap.remove(entry.getKey());
            }
        }
    }

    public void sessionTimeout(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.setMaxInactiveInterval(0);
        }
    }
}