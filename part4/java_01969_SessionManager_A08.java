import java.util.HashMap;
import java.util.Map;

public class java_01969_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_01969_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) throws Exception {
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("Invalid session ID");
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}