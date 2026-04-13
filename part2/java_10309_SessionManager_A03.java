import java.util.HashMap;
import java.util.Map;

public class java_10309_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_10309_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(sessionMap.size() + 1);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}