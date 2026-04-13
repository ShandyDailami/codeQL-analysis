import java.util.HashMap;
import java.util.Map;

public class java_10230_SessionManager_A01 {
    private Map<String, String> sessionStore;

    public java_10230_SessionManager_A01() {
        sessionStore = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionStore.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}