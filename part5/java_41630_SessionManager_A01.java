import java.util.HashMap;
import java.util.Map;

public class java_41630_SessionManager_A01 {
    private Map<String, String> store;

    public java_41630_SessionManager_A01() {
        this.store = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        store.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return store.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        store.remove(sessionId);
    }
}