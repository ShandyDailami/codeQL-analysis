import java.util.HashMap;
import java.util.Map;

public class java_24966_SessionManager_A07 {

    // A simple in-memory store for session data
    private Map<String, Object> sessionData;

    public java_24966_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionData.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessionData.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}