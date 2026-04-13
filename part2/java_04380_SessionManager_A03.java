import java.util.ArrayList;
import java.util.List;

public class java_04380_SessionManager_A03 {
    private static final int MAX_SESSIONS = 10;

    private final List<String> sessions = new ArrayList<>(MAX_SESSIONS);

    public void openSession(String sessionId) {
        if (sessions.size() < MAX_SESSIONS) {
            sessions.add(sessionId);
            System.out.println("Opened session: " + sessionId);
        } else {
            System.out.println("Cannot open session: Session limit reached");
        }
    }

    public void closeSession(String sessionId) {
        if (sessions.remove(sessionId)) {
            System.out.println("Closed session: " + sessionId);
        } else {
            System.out.println("Cannot close session: Session not found");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.openSession("session1");
        manager.openSession("session2");
        manager.openSession("session3");
        manager.openSession("session4");
        manager.openSession("session5");
        manager.openSession("session6");

        manager.closeSession("session2");
        manager.closeSession("session5");
    }
}