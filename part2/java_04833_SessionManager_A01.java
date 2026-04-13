import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_04833_SessionManager_A01 {
    private Map<String, String> sessionStore;

    public java_04833_SessionManager_A01() {
        sessionStore = new ConcurrentHashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}