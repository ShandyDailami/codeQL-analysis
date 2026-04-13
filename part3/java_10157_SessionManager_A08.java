import java.util.HashSet;
import java.util.Set;

public class java_10157_SessionManager_A08 {

    private Set<String> activeSessions;

    public java_10157_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public synchronized void startSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
        } else {
            System.out.println("Failed to start session: Session " + sessionId + " already exists");
        }
    }

    public synchronized void endSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
        } else {
            System.out.println("Failed to end session: Session " + sessionId + " does not exist");
        }
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Session1");
        sessionManager.startSession("Session2");
        sessionManager.startSession("Session1"); // Should print a message
        sessionManager.endSession("Session2");
        sessionManager.endSession("Session3"); // Should print a message

        System.out.println("Is Session1 active? " + (sessionManager.isSessionActive("Session1") ? "Yes" : "No"));
        System.out.println("Is Session2 active? " + (sessionManager.isSessionActive("Session2") ? "Yes" : "No"));
        System.out.println("Is Session3 active? " + (sessionManager.isSessionActive("Session3") ? "Yes" : "No"));
    }
}