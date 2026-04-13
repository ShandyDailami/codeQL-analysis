import java.util.HashMap;
import java.util.Map;

public class java_35908_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35908_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = username + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String session = manager.createSession("alice");
        System.out.println("Session created: " + session);
        String username = manager.getUsername(session);
        System.out.println("Username: " + username);
        manager.removeSession(session);
        System.out.println("Session removed: " + session);
    }
}