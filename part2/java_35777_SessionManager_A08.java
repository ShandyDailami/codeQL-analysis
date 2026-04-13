import java.util.HashMap;
import java.util.Map;

public class java_35777_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_35777_SessionManager_A08() {
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

    public void deleteUser(String userId) {
        // This is a security sensitive operation.
        // Remove the sessions of the user
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                deleteSession(entry.getKey());
            }
        }
    }

    public void integrityFailure() {
        // This is a security sensitive operation.
        // The user with ID '1000' is trying to delete itself.
        // This operation will cause integrity failure and delete all the user's sessions
        deleteUser("1000");
    }
}