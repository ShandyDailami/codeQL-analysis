import java.util.HashMap;
import java.util.Map;

public class java_09637_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09637_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean integrityFailure() {
        // simulate integrity failure when a session is not found
        if (!sessionMap.containsKey("unknownSessionId")) {
            return false;
        }
        return true;
    }
}