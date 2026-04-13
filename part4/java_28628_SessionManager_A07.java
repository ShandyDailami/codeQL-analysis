import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_28628_SessionManager_A07 {
    private Map<String, HttpSession> sessionMap;

    public java_28628_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId) throws IllegalStateException {
        if (!isSessionActive(sessionId)) {
            throw new IllegalStateException("Invalid session: " + sessionId);
        }
    }
}