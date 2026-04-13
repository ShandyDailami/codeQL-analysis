import java.util.LinkedList;
import java.util.List;

public class java_30907_SessionManager_A01 {
    private static List<String> sessions = new LinkedList<>();

    public void createSession(String sessionId) {
        sessions.add(sessionId);
        System.out.println("Created session: " + sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessions.remove(sessionId)) {
            System.out.println("Deleted session: " + sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public void accessSession(String sessionId) {
        if (sessions.contains(sessionId)) {
            System.out.println("Accessed session: " + sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1");
        manager.createSession("session2");
        manager.createSession("session3");

        manager.accessSession("session2");
        manager.deleteSession("session2");

        manager.accessSession("session4");
    }
}