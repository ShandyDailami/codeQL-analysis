import java.util.HashMap;
import java.util.Map;

public class java_38411_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38411_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session Already Exists");
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public void getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("User ID: " + userId);
        } else {
            System.out.println("Session Does Not Exists");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session Deleted");
        } else {
            System.out.println("Session Does Not Exists");
        }
    }

    public void updateSession(String sessionId, String newUserId) {
        if (sessionMap.containsKey(sessionId)) {
            String oldUserId = sessionMap.get(sessionId);
            sessionMap.replace(sessionId, oldUserId, newUserId);
            System.out.println("Session Updated");
        } else {
            System.out.println("Session Does Not Exists");
        }
    }
}