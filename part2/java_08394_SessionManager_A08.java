import java.util.HashSet;
import java.util.Set;

public class java_08394_SessionManager_A08 {
    private Set<Session> activeSessions;

    public java_08394_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public void openSession(String sessionId) {
        if (sessionExists(sessionId)) {
            System.out.println("Error: Session with ID: " + sessionId + " already exists.");
        } else {
            activeSessions.add(new Session(sessionId));
            System.out.println("Session with ID: " + sessionId + " has been opened.");
        }
    }

    public void closeSession(String sessionId) {
        if (sessionExists(sessionId)) {
            activeSessions.removeIf(session -> session.getId().equals(sessionId));
            System.out.println("Session with ID: " + sessionId + " has been closed.");
       
        } else {
            System.out.println("Error: Session with ID: " + sessionId + " does not exist.");
        }
    }

    public boolean sessionExists(String sessionId) {
        return activeSessions.stream().anyMatch(session -> session.getId().equals(sessionId));
    }

    private class Session {
        private String id;

        public java_08394_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.openSession("session1");
        sessionManager.openSession("session2");
        sessionManager.openSession("session3");

        sessionManager.closeSession("session2");

        sessionManager.openSession("session3");
    }
}