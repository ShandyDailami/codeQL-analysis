import java.util.HashMap;

public class java_36923_SessionManager_A08 {

    private HashMap<String, String> sessions;

    public java_36923_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "A08_IntegrityFailure: Session already exists with id " + sessionId;
        } else {
            sessions.put(sessionId, sessionId);
            return "Session created successfully with id " + sessionId;
        }
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session with id " + sessionId + " exists";
        } else {
            return "A08_IntegrityFailure: Session with id " + sessionId + " does not exist";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session with id " + sessionId + " deleted successfully";
        } else {
            return "A08_IntegrityFailure: Session with id " + sessionId + " does not exist";
        }
    }
}