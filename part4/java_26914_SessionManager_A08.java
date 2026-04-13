import java.util.HashMap;
import java.util.Map;

public class java_26914_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_26914_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            Session newSession = new Session(sessionId);
            sessionMap.put(sessionId, newSession);
        }
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public static class Session {
        private String id;

        public java_26914_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.getSession("session1");
        Session session2 = sessionManager.getSession("session2");
        Session session3 = sessionManager.getSession("session3");

        sessionManager.closeSession("session2");

        System.out.println("Session 1 id: " + session1.getId());
        System.out.println("Session 2 id: " + session2.getId());
        System.out.println("Session 3 id: " + session3.getId());
    }
}