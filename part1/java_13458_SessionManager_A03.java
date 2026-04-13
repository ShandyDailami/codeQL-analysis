import java.util.HashMap;
import java.util.Map;

public class java_13458_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_13458_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        }
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(username, sessionId);
        return sessionId;
    }

    public String getUsernameBySessionId(String sessionId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void removeSession(String sessionId) {
        String username = getUsernameBySessionId(sessionId);
        if (username != null) {
            sessionMap.remove(username);
        }
    }
}