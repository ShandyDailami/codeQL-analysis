import java.util.HashMap;
import java.util.Map;

public class java_02514_SessionManager_A03 {

    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_02514_SessionManager_A03() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String userId, String password) {
        String sessionId = userMap.get(userId);
        if (sessionId != null && sessionMap.get(sessionId).equals(password)) {
            throw new IllegalStateException("Session already exists for this user");
        }

        sessionId = String.valueOf(sessionMap.size() + 1);
        sessionMap.put(sessionId, password);
        userMap.put(userId, sessionId);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        String userId = userMap.get(sessionMap.get(sessionId));
        sessionMap.remove(sessionId);
        userMap.remove(userId);
    }

    public String getSessionUser(String sessionId) {
        return userMap.get(sessionMap.get(sessionId));
    }

    public boolean isValidSession(String sessionId, String password) {
        if (!sessionMap.containsKey(sessionId)) {
            return false;
        }

        return sessionMap.get(sessionId).equals(password);
    }
}