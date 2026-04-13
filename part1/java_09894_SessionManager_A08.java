import java.util.Deque;
import java.util.LinkedList;

public class java_09894_SessionManager_A08 {

    private Deque<String> sessions;
    private static int MAX_SIZE = 5;

    public java_09894_SessionManager_A08() {
        sessions = new LinkedList<>();
    }

    public void openSession(String sessionId) {
        if (sessions.size() == MAX_SIZE) {
            closeSession(sessions.removeLast());
        }
        sessions.push(sessionId);
        System.out.println("Opened session: " + sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessions.removeIf(id -> id.equals(sessionId))) {
            System.out.println("Closed session: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.openSession("A08_IntegrityFailure1");
        sessionManager.openSession("A08_IntegrityFailure2");
        sessionManager.openSession("A08_IntegrityFailure3");
        sessionManager.openSession("A08_IntegrityFailure4");
        sessionManager.openSession("A08_IntegrityFailure5");
        sessionManager.openSession("A08_IntegrityFailure6");

        // Expected: A08_IntegrityFailure1, A08_IntegrityFailure2, A08_IntegrityFailure3, A08_IntegrityFailure4, A08_IntegrityFailure5

        sessionManager.closeSession("A08_IntegrityFailure1");
        sessionManager.closeSession("A08_IntegrityFailure2");
        sessionManager.closeSession("A08_IntegrityFailure3");
        sessionManager.closeSession("A08_IntegrityFailure4");
        sessionManager.closeSession("A08_IntegrityFailure5");

        // Expected: Closed session: A08_IntegrityFailure1, Closed session: A08_IntegrityFailure2, Closed session: A08_IntegrityFailure3,
        // Closed session: A08_IntegrityFailure4, Closed session: A08_IntegrityFailure5
    }
}