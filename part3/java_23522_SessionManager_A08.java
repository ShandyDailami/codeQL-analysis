import java.util.HashMap;
import java.util.Map;

public class java_23522_SessionManager_A08 {
    private Map<String, String> sessionStorage;

    public java_23522_SessionManager_A08() {
        sessionStorage = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionStorage.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }

    // Here are some security-related methods.
    // You should implement these methods according to your security requirements.

    public void checkSessionIdIntegrity(String sessionId) {
        if (!sessionStorage.containsKey(sessionId)) {
            throw new SecurityException("Session ID is not valid or has expired.");
        }
    }

    public void checkUserIdIntegrity(String userId) {
        for (String sessionId : sessionStorage.keySet()) {
            if (sessionStorage.get(sessionId).equals(userId)) {
                return; // User ID is valid, no need to check further.
            }
        }
        throw new SecurityException("User ID is not valid.");
    }
}