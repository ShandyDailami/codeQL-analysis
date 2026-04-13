import java.util.HashMap;
import java.util.Map;

public class java_39291_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_39291_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        String sessionId = sessionMap.get(userId);

        // Security sensitive operation related to A07_AuthFailure
        // Authenticate the user and validate their credentials
        if (!authenticateUser(userId, sessionId)) {
            throw new AuthFailureException("Authentication failed");
        }

        return sessionId;
    }

    // Security sensitive operation related to A07_AuthFailure
    private boolean authenticateUser(String userId, String sessionId) {
        // Add authentication logic here, for example by comparing the userId with a stored userId
        return userId.equals(sessionMap.get(userId));
    }
}