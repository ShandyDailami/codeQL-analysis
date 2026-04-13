import java.util.HashSet;
import java.util.Set;

public class java_27325_SessionManager_A01 {
    // Data structure for storing session identifiers
    private Set<String> sessionIds;

    // Constructor
    public java_27325_SessionManager_A01() {
        sessionIds = new HashSet<>();
    }

    // Method for starting a new session
    public void startSession(String sessionId) throws IllegalStateException {
        if (sessionIds.contains(sessionId)) {
            throw new IllegalStateException("Session with ID: " + sessionId + " already exists!");
        }
        sessionIds.add(sessionId);
        System.out.println("Started session with ID: " + sessionId);
    }

    // Method for ending a session
    public void endSession(String sessionId) throws IllegalStateException {
        if (!sessionIds.contains(sessionId)) {
            throw new IllegalStateException("Session with ID: " + sessionId + " does not exist!");
        }
        sessionIds.remove(sessionId);
        System.out.println("Ended session with ID: " + sessionId);
    }

    // Method for checking if a session exists
    public boolean isSessionActive(String sessionId) {
        return sessionIds.contains(sessionId);
    }
}