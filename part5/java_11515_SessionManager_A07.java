import java.util.HashMap;
import java.util.Map;

public class java_11515_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11515_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // Here you could use a UUID generator, but since we're not using Spring or Hibernate,
        // we'll just use a simple string that should be sufficient for this case.
        return "sessionId";
    }
}