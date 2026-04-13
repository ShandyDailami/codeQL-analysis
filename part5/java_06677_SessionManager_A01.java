import java.util.HashMap;
import java.util.Map;

public class java_06677_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_06677_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (isSessionActive(sessionId)) {
            System.out.println("Error: Session already active!");
            return;
        }
        sessions.put(sessionId, userId);
        System.out.println("Session created with ID: " + sessionId + " and User ID: " + userId);
    }

    public void endSession(String sessionId) {
        if (!isSessionActive(sessionId)) {
            System.out.println("Error: Session already inactive!");
            return;
        }
        sessions.remove(sessionId);
        System.out.println("Session ended with ID: " + sessionId);
    }

    public String getUserId(String sessionId) {
        if (!isSessionActive(sessionId)) {
            System.out.println("Error: No active session with this ID!");
            return null;
        }
        return sessions.get(sessionId);
    }

    private boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}