import java.util.HashMap;
import java.util.Map;

public class java_16477_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16477_SessionManager_A01() {
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
}