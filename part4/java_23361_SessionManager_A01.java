import java.util.HashMap;
import java.util.Map;

public class java_23361_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_23361_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        sessions.put(userId, "active");
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        if (sessions.containsKey(userId) && sessions.get(userId).equals("active")) {
            sessions.put(userId, "inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("user1");
        sm.endSession("user1");
        sm.endSession("user2"); // No active session
        sm.startSession("user3");
        sm.endSession("user3"); // No active session
    }
}