import java.util.HashMap;
import java.util.Map;

public class java_31671_SessionManager_A03 {
    // Store sessions in a HashMap
    private Map<String, String> sessionMap;

    public java_31671_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Use UUID to generate a unique session id
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId of a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}