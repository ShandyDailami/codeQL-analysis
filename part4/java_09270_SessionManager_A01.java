import java.util.HashMap;
import java.util.Map;

public class java_09270_SessionManager_A01 {
    private Map<String, String> sessionStore;

    public java_09270_SessionManager_A01() {
        sessionStore = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public void validateSession(String sessionId) throws InvalidSessionException {
        if (!sessionStore.containsKey(sessionId)) {
            throw new InvalidSessionException("Invalid Session");
        }
    }
}