import java.util.HashMap;
import java.util.Map;

public class java_28985_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28985_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.startSession("session1", "user1");
        sm.startSession("session2", "user2");

        System.out.println("Session1 user: " + sm.getUsername("session1"));
        System.out.println("Session2 user: " + sm.getUsername("session2"));

        sm.endSession("session1");

        System.out.println("Is session1 valid? " + sm.isValidSession("session1"));
        System.out.println("Is session2 valid? " + sm.isValidSession("session2"));
    }
}