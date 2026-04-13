import java.util.HashMap;
import java.util.Map;

public class java_02970_SessionManager_A08 {

    private Map<String, Session> sessions;

    public java_02970_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String id) {
        if (!sessions.containsKey(id)) {
            sessions.put(id, new Session(id));
        }
        return sessions.get(id);
    }

    public void closeSession(String id) {
        sessions.remove(id);
    }

    public void clear() {
        sessions.clear();
    }

    private class Session {

        private String id;

        public java_02970_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void open() {
            // Implementation here
        }

        public void close() {
            // Implementation here
        }
    }
}