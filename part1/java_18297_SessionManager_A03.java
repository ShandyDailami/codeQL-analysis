import java.util.HashMap;
import java.util.Map;

public class java_18297_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18297_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // This is a security-sensitive operation related to Injection.
        // It allows creating a session with a userId that is a command input.
        // This operation can be performed by an attacker, so we must prevent this.
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty.");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // This is a security-sensitive operation related to Injection.
        // It allows fetching the userId of a session.
        // This operation can be performed by an attacker, so we must prevent this.
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // This is a security-sensitive operation related to Injection.
        // It allows deleting a session.
        // This operation can be performed by an attacker, so we must prevent this.
        sessionMap.remove(sessionId);
    }
}