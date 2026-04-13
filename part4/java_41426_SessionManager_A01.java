import java.util.HashMap;
import java.util.Map;

public class java_41426_SessionManager_A01 {
    private Map<String, String> sessionData;

    public java_41426_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        // Access control check: ensure sessionId is not null and sessionData is not null
        if (sessionId == null || sessionData == null) {
            throw new IllegalArgumentException("SessionId and session data must not be null");
        }

        // Add session to session data
        this.sessionData.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        // Access control check: ensure sessionId is not null
        if (sessionId == null) {
            throw new IllegalArgumentException("SessionId must not be null");
        }

        // Retrieve session data
        return sessionData.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Access control check: ensure sessionId is not null
        if (sessionId == null) {
            throw new IllegalArgumentException("SessionId must not be null");
        }

        // Delete session from session data
        sessionData.remove(sessionId);
    }
}