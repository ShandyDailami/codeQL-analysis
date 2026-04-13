import java.util.HashMap;
import java.util.Map;

public class java_40130_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_40130_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        // Assume that this operation can raise an exception, which is not allowed
        // In a real-world scenario, this operation should be protected by try-catch blocks
        // and error handling mechanisms.
        // For simplicity, we're not doing any real access control checks here.

        // Generate a session id
        String sessionId = userId + "-" + System.currentTimeMillis();

        // Store the session id in the session map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Assume that this operation can raise an exception, which is not allowed
        // In a real-world scenario, this operation should be protected by try-catch blocks
        // and error handling mechanisms.
        // For simplicity, we're not doing any real access control checks here.

        return sessionMap.get(sessionId);
    }
}