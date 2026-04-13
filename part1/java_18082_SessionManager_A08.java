import java.util.HashMap;
import java.util.Map;

public class java_18082_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_18082_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        sessionManager.createSession("session2", "user2");

        System.out.println("Is session 1 valid? " + sessionManager.isSessionValid("session1"));
        System.out.println("Is session 2 valid? " + sessionManager.isSessionValid("session2"));

        System.out.println("User in session 1: " + sessionManager.getUserId("session1"));
        System.out.println("User in session 2: " + sessionManager.getUserId("session2"));

        sessionManager.destroySession("session1");
        sessionManager.destroySession("session2");

        System.out.println("Is session 1 valid? " + sessionManager.isSessionValid("session1"));
        System.out.println("Is session 2 valid? " + sessionManager.isSessionValid("session2"));
    }
}