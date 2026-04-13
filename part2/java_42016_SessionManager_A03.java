import java.util.HashMap;
import java.util.Map;

public class java_42016_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_42016_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Error: Session with id " + sessionId + " already exists.");
        } else {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            System.out.println("Created session with id " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Deleted session with id " + sessionId);
        } else {
            System.out.println("Error: Session with id " + sessionId + " does not exist.");
        }
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            System.out.println("Error: Session with id " + sessionId + " does not exist.");
            return null;
        }
    }

    // Session class omitted for brevity
}