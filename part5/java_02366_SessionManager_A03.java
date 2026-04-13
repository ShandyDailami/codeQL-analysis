import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_02366_SessionManager_A03 {
    private Map<String, HttpSession> sessionMap;

    public java_02366_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(HttpSession session) {
        String sessionId = session.getId();
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
    }

    public void cleanup() {
        for (String sessionId : sessionMap.keySet()) {
            destroySession(sessionId);
        }
    }
}