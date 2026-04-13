import java.util.HashMap;
import java.util.Map;

public class java_04397_SessionManager_A08 {
    // A simple in-memory storage for the sessions.
    private Map<String, String> sessionStorage = new HashMap<>();

    // A simple in-memory storage for the integrity checks.
    private Map<String, String> integrityCheckStorage = new HashMap<>();

    // A simple method for creating a new session.
    public void createSession(String sessionId, String userId) {
        sessionStorage.put(sessionId, userId);
    }

    // A simple method for checking the integrity of a session.
    public void checkSessionIntegrity(String sessionId, String expectedUserId) {
        if (sessionStorage.containsKey(sessionId) &&
            sessionStorage.get(sessionId).equals(expectedUserId)) {
            integrityCheckStorage.put(sessionId, "OK");
        } else {
            integrityCheckStorage.put(sessionId, "FAILURE");
        }
    }

    // A simple method for retrieving the userId from a session.
    public String getUserIdFromSession(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    // A simple method for checking the integrity of a user's session.
    public String getIntegrityCheckResult(String sessionId) {
        return integrityCheckStorage.get(sessionId);
    }
}