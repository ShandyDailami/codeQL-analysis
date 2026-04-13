import java.util.ArrayList;
import java.util.List;

public class java_02179_SessionManager_A08 {
    private List<String> sessions;
    private int maxSessions;

    public java_02179_SessionManager_A08(int maxSessions) {
        this.sessions = new ArrayList<>();
        this.maxSessions = maxSessions;
    }

    public void openSession() {
        if (sessions.size() < maxSessions) {
            String sessionId = generateSessionId();
            sessions.add(sessionId);
            System.out.println("Opened session with ID: " + sessionId);
        } else {
            System.out.println("Maximum session limit reached");
        }
    }

    public void closeSession(String sessionId) {
        if (sessions.contains(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Closed session with ID: " + sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public void checkSessionIntegrity(String sessionId) {
        if (sessions.contains(sessionId)) {
            System.out.println("Session with ID: " + sessionId + " is valid");
        } else {
            System.out.println("Session with ID: " + sessionId + " is invalid");
        }
    }

    private String generateSessionId() {
        // This is a dummy session ID generation. In a real-world application, it should use a secure and unique mechanism.
        return "A08_IntegrityFailure";
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager(2);

        manager.openSession();
        manager.openSession();

        manager.checkSessionIntegrity("A08_IntegrityFailure");

        manager.closeSession("A08_IntegrityFailure");
        manager.closeSession("A08_IntegrityFailure");

        manager.checkSessionIntegrity("A08_IntegrityFailure");
    }
}