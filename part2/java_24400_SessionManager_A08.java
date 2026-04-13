import java.util.HashMap;
import java.util.Map;

public class java_24400_SessionManager_A08 {
    private Map<String, String> sessionStore;

    public java_24400_SessionManager_A08() {
        sessionStore = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionStore.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}