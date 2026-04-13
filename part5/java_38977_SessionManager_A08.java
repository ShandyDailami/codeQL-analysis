import java.util.HashMap;
import java.util.Map;

public class java_38977_SessionManager_A08 {

    // This is a simple session storage. In a real-world application, you would use a database or another storage system.
    private Map<String, String> sessionStorage = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionStorage.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }

    // This is a simple way to generate a session id. In a real-world application, you would use a UUID or similar to make the session id unique.
    private String generateSessionId() {
        return Long.toString(System.nanoTime(), 36);
    }
}