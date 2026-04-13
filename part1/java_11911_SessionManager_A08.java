import java.util.HashMap;
import java.util.Map;

public class java_11911_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11911_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(username, sessionId);
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void deleteSession(String username) {
        sessionMap.remove(username);
    }

    public boolean isValidSession(String username, String sessionId) {
        return sessionMap.containsKey(username) && sessionMap.get(username).equals(sessionId);
    }
}