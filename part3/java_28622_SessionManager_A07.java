import java.util.HashMap;
import java.util.Map;

public class java_28622_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28622_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.addSession("session1", "user1");
        manager.addSession("session2", "user2");

        System.out.println("Is session1 valid? " + manager.isSessionValid("session1"));
        System.out.println("Is session2 valid? " + manager.isSessionValid("session2"));
        System.out.println("User in session1: " + manager.getUserId("session1"));
        System.out.println("User in session2: " + manager.getUserId("session2"));

        manager.removeSession("session1");

        System.out.println("Is session1 valid? " + manager.isSessionValid("session1"));
    }
}