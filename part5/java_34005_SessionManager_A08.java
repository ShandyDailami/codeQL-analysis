import java.util.HashMap;
import java.util.Map;

public class java_34005_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_34005_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
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