import java.util.HashMap;

public class java_14321_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_14321_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String id) {
        if (sessions.containsKey(id)) {
            return sessions.get(id);
        } else {
            Session session = new Session(id);
            sessions.put(id, session);
            return session;
        }
    }

    public void closeSession(String id) {
        if (sessions.containsKey(id)) {
            sessions.get(id).dispose();
            sessions.remove(id);
        }
    }

    private class Session {
        private String id;

        public java_14321_SessionManager_A08(String id) {
            this.id = id;
            // Session initialization code here
            System.out.println("Session " + id + " created.");
        }

        public void dispose() {
            // Session dispose code here
            System.out.println("Session " + id + " destroyed.");
        }
    }
}