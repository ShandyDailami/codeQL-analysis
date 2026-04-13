import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class java_35633_SessionManager_A08 {
    private Map<String, Session> sessions;
    private Random random;

    public java_35633_SessionManager_A08() {
        sessions = new HashMap<>();
        random = new Random();
    }

    public String createSession() {
        String sessionId = generateSessionId();
        sessions.put(sessionId, new Session());
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(random.nextLong());
    }

    private class Session {
        // Empty for now
    }
}