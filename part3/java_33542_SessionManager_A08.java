import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class java_33542_SessionManager_A08 {
    // A list to store all sessions
    private ArrayList<Session> sessions;

    // A map to look up sessions by their ID
    private HashMap<String, Session> sessionMap;

    public java_33542_SessionManager_A08() {
        sessions = new ArrayList<>();
        sessionMap = new HashMap<>();
    }

    // Start a new session
    public Session startSession() {
        Session session = new Session(UUID.randomUUID().toString());
        sessions.add(session);
        sessionMap.put(session.getId(), session);
        return session;
    }

    // Get a session by its ID
    public Session getSession(String id) {
        return sessionMap.get(id);
    }

    // End a session
    public void endSession(Session session) {
        sessions.remove(session);
        sessionMap.remove(session.getId());
    }

    // A simple session class
    public static class Session {
        private String id;

        public java_33542_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}