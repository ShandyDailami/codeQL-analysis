import java.util.HashMap;
import java.util.Map;

public class java_39719_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_39719_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created successfully!");
        }
    }

    public void getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("User ID: " + userId);
        } else {
            System.out.println("Session does not exist!");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted successfully!");
        } else {
            System.out.println("Session does not exist!");
        }
    }
}