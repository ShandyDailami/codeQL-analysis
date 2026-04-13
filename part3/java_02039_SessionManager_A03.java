import java.util.HashMap;

public class java_02039_SessionManager_A03 {

    private HashMap<String, Session> sessionMap;

    public java_02039_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Session session) {
        sessionMap.put(session.getId(), session);
        return session.getId();
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_02039_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}