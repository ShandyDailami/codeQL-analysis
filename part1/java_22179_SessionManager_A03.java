import java.util.HashMap;
import java.util.Map;

public class java_22179_SessionManager_A03 {
    // A map to simulate a database where session IDs are keys and session objects are values.
    private Map<String, Session> sessionMap;

    // Session class, it includes session ID and a map to simulate a database.
    public class Session {
        private String id;
        private Map<String, String> database;

        public java_22179_SessionManager_A03(String id) {
            this.id = id;
            this.database = new HashMap<>();
        }

        public void put(String key, String value) {
            database.put(key, value);
        }

        public String get(String key) {
            return database.get(key);
        }

        public void invalidate() {
            // Simulating invalidation by clearing the database.
            database.clear();
        }
    }

    public java_22179_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public Session createSession(String id) {
        Session session = new Session(id);
        sessionMap.put(id, session);
        return session;
    }

    public Session getSession(String id) {
        return sessionMap.get(id);
    }

    public void destroySession(String id) {
        Session session = sessionMap.get(id);
        if (session != null) {
            session.invalidate();
            sessionMap.remove(id);
        }
    }
}