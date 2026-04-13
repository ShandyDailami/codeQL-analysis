import java.util.HashMap;
import java.util.Map;

public class java_39624_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39624_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
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

    // Add more operations as needed for security-sensitive operations
}