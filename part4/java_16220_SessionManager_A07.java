import java.util.HashMap;
import java.util.Map;

public class java_16220_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16220_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String sessionId = manager.createSession("alice");
        String username = manager.getUsername(sessionId);
        System.out.println("Username: " + username);
        manager.deleteSession(sessionId);
    }
}