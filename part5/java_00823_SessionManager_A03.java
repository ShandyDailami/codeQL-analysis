import java.util.HashMap;
import java.util.Map;

public class java_00823_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_00823_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
            return;
        }
        sessionMap.put(sessionId, userId);
        System.out.println("Session created successfully!");
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No such session exists!");
            return;
        }
        sessionMap.remove(sessionId);
        System.out.println("Session deleted successfully!");
    }

    public void accessSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No such session exists!");
            return;
        }
        String userId = sessionMap.get(sessionId);
        System.out.println("User ID for this session is: " + userId);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        sessionManager.createSession("session1", "user1");
        sessionManager.accessSession("session1");
        sessionManager.deleteSession("session1");
        sessionManager.accessSession("session1");
    }
}