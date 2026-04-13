import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class java_33901_SessionManager_A07 {
    private Map<String, HttpSession> sessionMap;

    public java_33901_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public Collection<HttpSession> getAllSessions() {
        return sessionMap.values();
    }

    public void invalidateSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
    }

    public void validateSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.validate(true);
        }
    }
}