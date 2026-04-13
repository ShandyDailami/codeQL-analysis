import java.util.HashMap;

public class java_06124_SessionManager_A08 {
    private HashMap<String, String> sessionData;

    public java_06124_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionId) {
        // If session already exists, remove it
        if (sessionData.containsKey(sessionId)) {
            removeSession(sessionId);
        }

        // Create new session
        sessionData.put(sessionId, "Session Started");
    }

    public void removeSession(String sessionId) {
        // Remove session
        sessionData.remove(sessionId);

        // Check for integrity failure
        if (!sessionData.containsKey(sessionId)) {
            System.out.println("Integrity Failure: Session has been removed but was not found.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("session1");
        manager.startSession("session2");
        manager.startSession("session1"); // Expected to remove session1
        manager.removeSession("session3"); // Expected to not find session3
    }
}