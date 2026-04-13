import java.util.HashMap;
import java.util.Map;

public class java_03964_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03964_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) throws Exception {
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("Invalid session id");
        }
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) throws Exception {
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("Invalid session id");
        }
        sessionMap.remove(sessionId);
    }
}