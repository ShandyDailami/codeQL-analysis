import java.util.ArrayList;
import java.util.List;

public class java_16163_SessionManager_A08 {
    private List<String> sessions;
    private int sessionCount;

    public java_16163_SessionManager_A08() {
        sessions = new ArrayList<>();
        sessionCount = 0;
    }

    public String createSession() {
        String sessionId = "A08_" + sessionCount;
        sessions.add(sessionId);
        sessionCount++;
        return sessionId;
    }

    public boolean deleteSession(String sessionId) {
        if (sessions.contains(sessionId)) {
            sessions.remove(sessionId);
            return true;
        } else {
            return false;
        }
    }

    public boolean isSessionValid(String sessionId) {
        if (sessionId != null && sessionId.length() > 0) {
            if (sessions.contains(sessionId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String session1 = manager.createSession();
        String session2 = manager.createSession();
        String session3 = manager.createSession();

        System.out.println("Created sessions: " + session1 + ", " + session2 + ", " + session3);

        boolean validSession1 = manager.isSessionValid(session1);
        boolean validSession2 = manager.isSessionValid(session2);
        boolean validSession3 = manager.isSessionValid(session3);

        System.out.println("Valid sessions: " + validSession1 + ", " + validSession2 + ", " + validSession3);

        boolean validSessionA08_0 = manager.isSessionValid("A08_0");
        boolean validSessionA08_1 = manager.isSessionValid("A08_1");

        System.out.println("Valid A08 sessions: " + validSessionA08_0 + ", " + validSessionA08_1);

        boolean invalidSession1 = manager.deleteSession("InvalidSession");
        boolean invalidSessionA08_1 = manager.deleteSession("A08_1");

        System.out.println("Deleted sessions: " + invalidSession1 + ", " + invalidSessionA08_1);
    }
}