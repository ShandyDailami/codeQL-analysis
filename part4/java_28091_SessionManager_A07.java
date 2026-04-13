import java.util.HashMap;
import java.util.Map;

public class java_28091_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28091_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(username, sessionId);
        return sessionId;
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void destroySession(String username) {
        sessionMap.remove(username);
    }
}