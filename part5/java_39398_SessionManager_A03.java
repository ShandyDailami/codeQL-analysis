import java.util.HashMap;
import java.util.Map;

public class java_39398_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39398_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username == null) {
            throw new IllegalArgumentException("Invalid session id");
        }
        return username;
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}