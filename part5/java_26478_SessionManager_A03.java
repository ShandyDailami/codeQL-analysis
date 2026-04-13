import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_26478_SessionManager_A03 {
    // Session storage is a map
    private Map<UUID, String> sessionStorage = new HashMap<>();

    // Create a session
    public String createSession(String sessionContent) {
        UUID sessionId = UUID.randomUUID();
        sessionStorage.put(sessionId, sessionContent);
        return sessionId.toString();
    }

    // Retrieve session content
    public String getSessionContent(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    // Remove session
    public void removeSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }
}