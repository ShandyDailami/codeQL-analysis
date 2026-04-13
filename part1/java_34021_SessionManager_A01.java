import java.util.HashMap;
import java.util.Map;

public class java_34021_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34021_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}