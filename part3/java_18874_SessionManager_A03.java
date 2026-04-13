import java.util.HashMap;
import java.util.Map;

public class java_18874_SessionManager_A03 {

    // A map to store the sessions.
    private Map<String, Session> sessions = new HashMap<>();

    // A session is just a map with String as key and Object as value.
    private class Session extends HashMap<String, Object> {
        @Override
        public Object put(String key, Object value) {
            return super.put(key, value);
        }
    }

    // Get a session.
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session();
            sessions.put(sessionId, session);
        }
        return session;
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // This method is used to validate the session.
    public void validateSession(String sessionId) throws IllegalAccessException {
        Session session = getSession(sessionId);
        if (session == null || session.isEmpty()) {
            throw new IllegalAccessException("Invalid session: " + sessionId);
        }
    }
}