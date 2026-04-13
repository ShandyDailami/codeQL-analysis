import java.util.HashMap;
import java.util.Map;

public class java_14077_SessionManager_A03 {
    // private data structure to hold sessions
    private Map<String, Session> sessionMap;

    // Session class
    public class Session {
        private String id;
        private Object data;

        public java_14077_SessionManager_A03(String id, Object data) {
            this.id = id;
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public Object getData() {
            return data;
        }
    }

    // constructor
    public java_14077_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // method to create a new session
    public String createSession(Object data) {
        String id = String.valueOf(System.currentTimeMillis());
        Session session = new Session(id, data);
        sessionMap.put(id, session);
        return id;
    }

    // method to get a session
    public Object getSession(String id) {
        Session session = sessionMap.get(id);
        return session != null ? session.getData() : null;
    }

    // method to delete a session
    public void deleteSession(String id) {
        sessionMap.remove(id);
    }
}