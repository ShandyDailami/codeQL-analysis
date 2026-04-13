import java.util.HashMap;

public class java_27987_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_27987_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static class Session {
        private String data;

        public java_27987_SessionManager_A08(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}