import java.util.HashMap;
import java.util.Map;

public class java_38019_SessionManager_A01 {
    // private map to hold session objects
    private Map<String, Session> sessionMap;

    // constructor to create the map
    public java_38019_SessionManager_A01() {
        sessionMap = new HashMap<String, Session>();
    }

    // method to add a session to the map
    public void addSession(Session session) {
        sessionMap.put(session.getId(), session);
    }

    // method to get a session from the map
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // method to remove a session from the map
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class to represent a user session
    public class Session {
        private String id;

        // constructor to create a session
        public java_38019_SessionManager_A01(String id) {
            this.id = id;
        }

        // method to get the session id
        public String getId() {
            return id;
        }

        // method to set the session id
        public void setId(String id) {
            this.id = id;
        }
    }
}