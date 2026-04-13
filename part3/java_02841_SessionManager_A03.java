import java.util.HashMap;
import java.util.Map;

public class java_02841_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02841_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userName) {
        if (sessionMap.containsKey(userName)) {
            return sessionMap.get(userName);
        } else {
            String sessionId = generateSessionId(userName);
            sessionMap.put(userName, sessionId);
            return sessionId;
        }
    }

    private String generateSessionId(String userName) {
        // This is a placeholder for a security-sensitive operation related to A03_Injection
        // It should be replaced with a real implementation
        return userName + System.currentTimeMillis();
    }

    public void invalidateSession(String sessionId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                sessionMap.remove(entry.getKey());
                break;
            }
        }
    }
}