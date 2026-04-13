import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

public class java_09239_SessionManager_A08 {
    private ConcurrentHashMap<String, String> sessionMap;

    public java_09239_SessionManager_A08() {
        this.sessionMap = new ConcurrentHashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}