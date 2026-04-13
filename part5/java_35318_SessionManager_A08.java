import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_35318_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_35318_SessionManager_A08() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_35318_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}