import java.util.HashMap;
import java.util.Map;

public class java_41257_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_41257_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId) {
        // Simulating database insert operation.
        sessions.put(userId, "session_id_" + userId);
        System.out.println("Session created for user: " + userId);
    }

    public void getSession(String userId) {
        // Simulating database select operation.
        String sessionId = sessions.get(userId);
        if (sessionId != null) {
            System.out.println("Session found for user: " + userId);
            System.out.println("Session ID: " + sessionId);
        } else {
            System.out.println("No session found for user: " + userId);
        }
    }

    public void closeSession(String userId) {
        // Simulating database delete operation.
        String sessionId = sessions.get(userId);
        if (sessionId != null) {
            sessions.remove(userId);
            System.out.println("Session closed for user: " + userId);
        } else {
            System.out.println("No session found for user: " + userId);
        }
    }
}