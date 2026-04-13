import java.util.HashMap;
import java.util.Map;

public class java_07989_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07989_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // or throw an exception
        }
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("session1", "user1");
        sm.createSession("session2", "user2");

        System.out.println("User " + sm.getUserId("session1") + " is logged in.");
        System.out.println("User " + sm.getUserId("session2") + " is logged in.");

        sm.endSession("session1");
        sm.endSession("session2");
    }
}