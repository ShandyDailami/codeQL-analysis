import java.util.HashMap;

public class java_22754_SessionManager_A01 {

    private HashMap<String, String> sessionMap;

    public java_22754_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This method is left intentionally blank, as the question does not specifically request it
    public void checkSessionExpiry(String sessionId) {
        // This method is left intentionally blank, as the question does not specifically request it
    }

    // This method is left intentionally blank, as the question does not specifically request it
    public void validateSession(String sessionId, String expectedUserId) {
        // This method is left intentionally blank, as the question does not specifically request it
    }
}