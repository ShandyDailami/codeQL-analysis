import java.util.HashMap;
import java.util.Map;

public class java_40751_SessionManager_A08 {

    // Create a map to hold session IDs and Session objects
    private Map<String, Session> sessionMap;

    // Session class
    public static class Session {
        private String id;
        private Object object;

        public java_40751_SessionManager_A08(String id, Object object) {
            this.id = id;
            this.object = object;
        }

        public String getId() {
            return id;
        }

        public Object getObject() {
            return object;
        }
    }

    // Constructor
    public java_40751_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Add a session
    public String addSession(Object object) {
        String id = java.util.UUID.randomUUID().toString();
        Session session = new Session(id, object);
        sessionMap.put(id, session);
        return id;
    }

    // Get a session
    public Object getSession(String id) {
        Session session = sessionMap.get(id);
        if(session == null) {
            throw new SecurityException("Session not found");
        }
        return session.getObject();
    }

    // Remove a session
    public void removeSession(String id) {
        sessionMap.remove(id);
    }
}