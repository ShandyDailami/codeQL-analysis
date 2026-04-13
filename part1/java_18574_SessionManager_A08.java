import java.util.ArrayList;
import java.util.List;

public class java_18574_SessionManager_A08 {
    private List<String> sessions;

    public java_18574_SessionManager_A08() {
        this.sessions = new ArrayList<>();
    }

    public void startSession() {
        // Secure operation
        // Verify if there is an active session, if not create a new one
        if (sessions.isEmpty()) {
            System.out.println("Started a new session with id " + (sessions.size() + 1));
            sessions.add("Session " + (sessions.size() + 1));
        } else {
            System.out.println("Attempted to start a new session, but an active session already exists.");
        }
    }

    public void endSession(String sessionId) {
        // Secure operation
        // Check if the provided session id corresponds to an existing session
        if (sessions.contains(sessionId)) {
            System.out.println("Ended session with id " + sessionId);
            sessions.remove(sessionId);
        } else {
            System.out.println("Attempted to end a non-existing session with id " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession();
        manager.endSession("Session 1");
        manager.startSession();
        manager.endSession("NonExistentSession");
    }
}