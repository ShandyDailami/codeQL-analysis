import java.util.HashMap;
import java.util.Map;

public class java_21362_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_21362_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operations related to A08_IntegrityFailure
    public void setIntegrityFailure(String sessionId) {
        // Simulates a possible integrity failure.
        // In a real application, this would involve checking if a session exists and the user is authorized to modify it.
        deleteSession(sessionId);
    }
}