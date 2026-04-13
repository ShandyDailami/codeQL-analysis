import java.util.HashMap;
import java.util.Map;

public class java_12568_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_12568_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists");
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with id " + sessionId + " exists");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with id " + sessionId + " exists");
        }
        sessionMap.remove(sessionId);
    }
}