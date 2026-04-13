import java.util.HashMap;
import java.util.Map;

public class java_19289_SessionManager_A03 {
    // A simple in-memory session store
    private Map<String, String> sessionStore;

    public java_19289_SessionManager_A03() {
        this.sessionStore = new HashMap<>();
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