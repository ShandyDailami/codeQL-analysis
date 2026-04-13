import javax.management.StandardSessionContext;
import java.util.HashMap;
import java.util.Map;

public class java_14454_SessionManager_A01 {

    // Create a map to store session id and session objects
    private Map<String, Session> sessionMap;

    public java_14454_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class Session {

        private String id;

        public java_14454_SessionManager_A01(String id) {
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
        String sessionId = sessionManager.createSession("session1");
        Session session = sessionManager.getSession("session1");
        System.out.println("Created session id: " + sessionId + ", Session id: " + session.getId());
        sessionManager.deleteSession("session1");
    }
}