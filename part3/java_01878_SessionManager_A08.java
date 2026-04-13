import java.util.HashMap;
import java.util.Map;

public class java_01878_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_01878_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void start() {
        // Start session tracking
    }

    public String get(String sessionId) {
        // Get session
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    public void close(String sessionId) {
        // Close session
        sessions.remove(sessionId);
    }
}