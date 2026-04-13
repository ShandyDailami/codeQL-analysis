import java.util.ArrayList;
import java.util.List;

public class java_18652_SessionManager_A08 {
    private List<String> activeSessions;

    public java_18652_SessionManager_A08() {
        this.activeSessions = new ArrayList<>();
    }

    public void createSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
            System.out.println("Created session: " + sessionId);
        } else {
            System.out.println("Session already exists: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            System.out.println("Ended session: " + sessionId);
        } else {
            System.out.println("Session does not exists: " + sessionId);
        }
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.createSession("A08_IntegrityFailure");
        manager.createSession("A08_IntegrityFailure");

        manager.endSession("A08_IntegrityFailure");

        System.out.println("Is session active? " + manager.isSessionActive("A08_IntegrityFailure"));
    }
}