import java.util.HashMap;

public class java_26600_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_26600_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "A08_IntegrityFailure: Session already exists.";
        } else {
            sessions.put(sessionId, sessionId);
            return "Session created successfully.";
        }
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session: " + sessions.get(sessionId);
        } else {
            return "A08_IntegrityFailure: Session does not exist.";
        }
    }

    public String destroySession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session destroyed successfully.";
        } else {
            return "A08_IntegrityFailure: Session does not exist.";
        }
    }
}