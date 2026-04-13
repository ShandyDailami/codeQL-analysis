import java.util.HashMap;
import java.util.Map;

public class java_05002_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_05002_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public Session getSession(String userId) {
        // if session already exists, return it
        if (sessions.containsKey(userId)) {
            return sessions.get(userId);
        }

        // else, create a new session and add it to the map
        Session newSession = new Session(userId);
        sessions.put(userId, newSession);
        return newSession;
    }

    public void closeSession(String userId) {
        // if session exists, remove it from the map
        if (sessions.containsKey(userId)) {
            sessions.remove(userId);
        }
    }

    // Session class could be something like this
    class Session {
        private String userId;

        public java_05002_SessionManager_A08(String userId) {
            this.userId = userId;
        }

        // methods to interact with the database related to the session
    }
}