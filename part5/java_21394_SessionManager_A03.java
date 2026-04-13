import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_21394_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_21394_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, user); // Store the session ID and user in the map
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}