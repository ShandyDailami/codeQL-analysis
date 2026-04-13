import java.util.HashMap;
import java.util.Map;

public class java_07081_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_07081_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session Already Exists");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session Created with ID: " + sessionId + " and User ID: " + userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session does not exist");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session Deleted with ID: " + sessionId);
        } else {
            System.out.println("Session does not exist");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("session1", "user1");
        System.out.println(sessionManager.getUserId("session1"));
        sessionManager.deleteSession("session1");
    }
}