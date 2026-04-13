import java.util.HashMap;
import java.util.Map;

public class java_09189_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09189_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }
        sessionMap.put(sessionId, "Active");
        return "Session created with id: " + sessionId;
    }

    public String deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
       
        }
        sessionMap.remove(sessionId);
        return "Session deleted with id: " + sessionId;
    }

    public String updateSession(String sessionId, String status) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
        }
        sessionMap.replace(sessionId, status);
        return "Session updated with id: " + sessionId;
    }

    public String getSessionStatus(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }
}