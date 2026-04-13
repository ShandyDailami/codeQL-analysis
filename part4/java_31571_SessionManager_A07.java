import java.util.HashMap;
import java.util.Map;

public class java_31571_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31571_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.nanoTime());
        this.sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Handle the case where sessionId is not found or is null
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}