import java.util.HashMap;
import java.util.Map;

public class java_01139_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_01139_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
        System.out.println("Session created for user: " + userId);
    }

    public void accessSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            String sessionId = sessionMap.get(userId);
            System.out.println("Accessing session for user: " + userId + ", sessionId: " + sessionId);
        } else {
            System.out.println("User: " + userId + ", does not exist in the session map.");
        }
    }

    public void destroySession(String userId) {
        if (sessionMap.containsKey(userId)) {
            String sessionId = sessionMap.get(userId);
            sessionMap.remove(userId);
            System.out.println("Session destroyed for user: " + userId + ", sessionId: " + sessionId);
        } else {
            System.out.println("User: " + userId + ", does not exist in the session map.");
        }
    }
}