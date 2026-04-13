import java.util.HashMap;
import java.util.Map;

public class java_19775_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_19775_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // This is a security risk, as the client may now use the sessionId to access any data.
            // You can implement proper error handling and logging here.
            throw new IllegalStateException("Invalid session ID: " + sessionId);
        }
    }

    public void updateSessionData(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        } else {
            // Same as above.
            throw new IllegalStateException("Invalid session ID: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            // Same as above.
            throw new IllegalStateException("Invalid session ID: " + sessionId);
        }
    }
}