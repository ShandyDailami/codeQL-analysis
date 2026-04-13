import java.util.HashMap;
import java.util.Map;

public class java_38598_SessionManager_A03 {
    private Map<String, Session> sessionMap;

    public java_38598_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessionMap.put(sessionId, session);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            sessionMap.remove(sessionId);
       
            // Here you could add code to remove references to the session in other sessions or to the database.
            // For this example, we're not doing that.
        }
    }

    public static class Session {
        private String id;

        public java_38598_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}