import java.util.HashMap;
import java.util.Map;

public class java_33295_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_33295_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        // In a real-world application, the user name should be hashed and salted before storage.
        // This is a placeholder for simplicity.
        String sessionId = userName + System.currentTimeMillis();
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        // Here we assume that the integrity of the session is checked when retrieving the user name.
        // In a real-world application, you would also check the session's expiration time and status.
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}