import java.util.HashMap;
import java.util.Map;

public class java_21443_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21443_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return null;
        }
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isSessionValid(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId).equals(sessionId);
        } else {
            return false;
        }
    }

    public void validateSession(String userId, String sessionId) throws AuthFailure {
        if (!isSessionValid(userId, sessionId)) {
            throw new AuthFailure("Invalid session");
        }
    }
}