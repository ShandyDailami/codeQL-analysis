import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class java_31396_SessionManager_A08 {

    private static final int MAX_SIZE = 100;
    private static final SecureRandom random = new SecureRandom();
    private List<String> sessions = new ArrayList<>();

    public String createSession() {
        String session;
        do {
            session = generateSessionId();
        } while (sessions.contains(session));
        sessions.add(session);
        return session;
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public String generateSessionId() {
        return String.valueOf(random.nextInt(MAX_SIZE));
    }

    public boolean isValidSession(String sessionId) {
        return sessions.contains(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String session1 = sessionManager.createSession();
        System.out.println("Created session: " + session1);

        String session2 = sessionManager.createSession();
        System.out.println("Created session: " + session2);

        sessionManager.deleteSession(session1);

        System.out.println("Session " + session1 + " is valid: " + sessionManager.isValidSession(session1));
        System.out.println("Session " + session2 + " is valid: " + sessionManager.isValidSession(session2));
    }
}