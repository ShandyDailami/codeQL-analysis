import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_31757_SessionManager_A08 {
    private Map<String, HttpSession> sessionMap;

    public java_31757_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(HttpSession session) {
        String sessionId = session.getId();
        sessionMap.put(sessionId, session);
    }

    public void endSession(HttpSession session) {
        String sessionId = session.getId();
        sessionMap.remove(sessionId);
    }

    public HttpSession getSessionByRequest(String requestId) {
        return sessionMap.get(requestId);
    }

    public void validateSession(HttpSession session) throws SecurityException {
        String sessionId = session.getId();
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session");
        }
    }
}