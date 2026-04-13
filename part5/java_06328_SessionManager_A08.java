import java.util.*;

public class java_06328_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_06328_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;
        private List<String> data;

        public java_06328_SessionManager_A08(String id) {
            this.id = id;
            this.data = new ArrayList<>();
        }

        public void store(String value) {
            data.add(value);
        }

        public String retrieve() {
            // Simulate a random integrity failure
            if (new Random().nextInt(10) == 1) {
                throw new RuntimeException("Integrity failure occurred while retrieving data.");
            }
            return data.get(new Random().nextInt(data.size()));
        }

        public void destroy() {
            // Simulate a random integrity failure
            if (new Random().nextInt(10) == 1) {
                throw new RuntimeException("Integrity failure occurred while destroying session.");
            }
            sessions.remove(id);
        }
    }
}