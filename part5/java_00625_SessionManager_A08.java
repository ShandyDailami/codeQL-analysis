import java.util.HashMap;
import java.util.Map;

public class java_00625_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_00625_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Utility methods to generate session id and check session id validity
    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    private boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Integrity failure related methods
    public void checkIntegrityFailure() throws IntegrityFailureException {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (!isSessionValid(entry.getKey())) {
                throw new IntegrityFailureException("Session ID " + entry.getKey() + " is not valid");
            }
        }
    }
}