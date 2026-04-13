import java.util.HashMap;
import java.util.Map;

public class java_33273_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_33273_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        if (!sessions.containsKey(userId)) {
            sessions.put(userId, "Active");
            System.out.println("Session started for user: " + userId);
        } else {
            System.out.println("User: " + userId + " already has an active session.");
        }
    }

    public void endSession(String userId) {
        if (sessions.containsKey(userId)) {
            sessions.put(userId, "Inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("User: " + userId + " doesn't have an active session.");
        }
    }

    public void checkSession(String userId) {
        if (sessions.containsKey(userId)) {
            if (sessions.get(userId).equals("Active")) {
                System.out.println("User: " + userId + " has an active session.");
            } else {
                System.out.println("User: " + userId + " doesn't have an active session.");
            }
        } else {
            System.out.println("User: " + userId + " doesn't have an active session.");
        }
    }
}