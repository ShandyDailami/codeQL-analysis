import java.util.HashMap;
import java.util.Map;

public class java_29006_SessionManager_A07 {
    private Map<String, String> store;

    public java_29006_SessionManager_A07() {
        store = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = java.util.UUID.randomUUID().toString();
        store.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return store.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        store.remove(sessionId);
    }
}