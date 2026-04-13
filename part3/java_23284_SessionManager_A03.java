import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.HashMap;
import java.util.Map;

public class java_23284_SessionManager_A03 {

    // Using a HashMap to simulate session storage
    private Map<String, HttpSession> sessionMap;

    public java_23284_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, HttpSession session) {
        sessionMap.put(sessionId, session);
    }

    public void destroySession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.setLastAccessed(System.currentTimeMillis());
        }
    }

    public void destroyAllSessions() {
        for(Map.Entry<String, HttpSession> entry : sessionMap.entrySet()) {
            entry.getValue().invalidate();
        }
        sessionMap.clear();
    }

    public long getActiveSessionCount() {
        return sessionMap.values().stream().filter(session -> !session.isExpired()).count();
    }
}