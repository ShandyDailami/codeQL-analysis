import java.util.ArrayList;
import java.util.List;

public class java_27825_SessionManager_A07 {
    private List<String> sessionIds;

    public java_27825_SessionManager_A07() {
        sessionIds = new ArrayList<>();
    }

    public void addSession(String sessionId) {
        sessionIds.add(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionIds.remove(sessionId);
    }

    public boolean containsSession(String sessionId) {
        return sessionIds.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add sessions
        sessionManager.addSession("session1");
        sessionManager.addSession("session2");
        sessionManager.addSession("session3");

        // Check if sessions exist
        System.out.println("Does session1 exist? " + sessionManager.containsSession("session1"));
        System.out.println("Does session4 exist? " + sessionManager.containsSession("session4"));

        // Remove session2
        sessionManager.removeSession("session2");

        // Check if session2 exists
        System.out.println("Does session2 exist? " + sessionManager.containsSession("session2"));
    }
}