import java.util.HashMap;
import java.util.Map;

public class java_28850_SessionManager_A08 {
    // This is a placeholder for a database. In a real application, you would use a database to store session data.
    private Map<String, String> sessionData;

    public java_28850_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionData.containsKey(sessionId)) {
            System.out.println("Session already exists. Please log in.");
            return;
        }

        sessionData.put(sessionId, userId);
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String sessionId) {
        if (!sessionData.containsKey(sessionId)) {
            System.out.println("No active session to end.");
            return;
        }

        sessionData.remove(sessionId);
        System.out.println("Session ended for user: " + sessionData.get(sessionId));
    }

    public String getUserId(String sessionId) {
        if (!sessionData.containsKey(sessionId)) {
            System.out.println("No active session.");
            return null;
        }

        return sessionData.get(sessionId);
    }
}