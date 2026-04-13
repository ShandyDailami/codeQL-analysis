import java.util.HashMap;
import java.util.Map;

public class java_34743_SessionManager_A08 {
    private Map<String, String> sessionStore;

    public java_34743_SessionManager_A08() {
        sessionStore = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionStore.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }
}