import java.util.HashMap;
import java.util.Map;

public class java_22739_SessionManager_A01 {

    private Map<String, Session> sessions;

    public java_22739_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public String startSession() {
        String id = UUID.randomUUID().toString();
        Session session = new Session(id);
        sessions.put(id, session);
        return id;
    }

    public void endSession(String id) {
        Session session = sessions.get(id);
        if (session != null) {
            sessions.remove(id);
        }
    }

    public void handleRequest(String id, String request) {
        Session session = sessions.get(id);
        if (session != null) {
            session.handleRequest(request);
        }
    }

    private class Session {

        private String id;
        private boolean active;

        public java_22739_SessionManager_A01(String id) {
            this.id = id;
            this.active = true;
        }

        public void handleRequest(String request) {
            if (active) {
                System.out.println("Session " + id + " handles request: " + request);
            } else {
                System.out.println("Session " + id + " is not active.");
            }
        }

        public void endSession() {
            active = false;
        }
    }
}