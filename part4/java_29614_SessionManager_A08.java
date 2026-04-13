import java.util.HashSet;

public class java_29614_SessionManager_A08 {
    private HashSet<String> activeSessions;

    public java_29614_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public synchronized void openSession(String sessionId) {
        activeSessions.add(sessionId);
        System.out.println("Session " + sessionId + " opened.");
    }

    public synchronized void closeSession(String sessionId) {
        activeSessions.remove(sessionId);
        System.out.println("Session " + sessionId + " closed.");
    }

    public synchronized void checkIntegrity() {
        if (activeSessions.isEmpty()) {
            System.out.println("No active sessions.");
            return;
        }

        for (String sessionId : activeSessions) {
            System.out.println("Session " + sessionId + " is still active.");
        }
    }
}