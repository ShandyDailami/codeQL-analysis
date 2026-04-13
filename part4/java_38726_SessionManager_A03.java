import java.util.HashMap;
import java.util.Map;

public class java_38726_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_38726_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void startSession(String user, String sessionId) {
        // Start session operation
        // For security-sensitive operations, injection should be avoided
        // This example only demonstrates a simple operation for brevity
        sessions.put(sessionId, user);
    }

    public String getUserBySessionId(String sessionId) {
        // Retrieve user operation
        // For security-sensitive operations, injection should be avoided
        // This example only demonstrates a simple operation for brevity
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        // End session operation
        // For security-sensitive operations, injection should be avoided
        // This example only demonstrates a simple operation for brevity
        sessions.remove(sessionId);
    }
}