import java.util.HashMap;
import java.util.Map;

public class java_25246_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_25246_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        String sessionId = sessionMap.get(username);
        if (sessionId == null) {
            sessionId = UUID.randomUUID().toString();
            sessionMap.put(username, sessionId);
        }
        return sessionId;
    }

    public String getUsername(String sessionId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void removeSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username != null) {
            sessionMap.remove(username);
        }
    }
}