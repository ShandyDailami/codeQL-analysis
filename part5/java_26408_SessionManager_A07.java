import java.util.HashMap;
import java.util.Map;

public class java_26408_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26408_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(username, sessionId);
    }

    public String getSession(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            return null;
        }
    }

    public void deleteSession(String username) {
        sessionMap.remove(username);
    }
}