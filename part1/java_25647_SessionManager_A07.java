import java.util.HashMap;
import java.util.Map;

public class java_25647_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_25647_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void authenticateUser(String sessionId, String password) {
        String userId = getUserId(sessionId);

        if (userId == null) {
            throw new AuthFailureException("Invalid session ID");
        }

        if (!password.equals(userId)) {
            throw new AuthFailureException("Password incorrect");
        }
    }
}