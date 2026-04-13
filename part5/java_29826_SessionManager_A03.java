import java.util.HashMap;
import java.util.Map;

public class java_29826_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_29826_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString(); // Generate a unique session ID
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