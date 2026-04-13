import java.util.HashMap;
import java.util.Map;

public class java_33176_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33176_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "user1");
        System.out.println(manager.getUserId("session1")); // Output: user1
        manager.deleteSession("session1");
        System.out.println(manager.isValidSession("session1")); // Output: false
    }
}