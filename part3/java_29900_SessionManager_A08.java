import java.util.HashMap;
import java.util.Map;

public class java_29900_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_29900_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists.");
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            System.out.println("Started session with id " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Ended session with id " + sessionId);
        } else {
            System.out.println("No session with id " + sessionId + " exists.");
        }
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            System.out.println("No session with id " + sessionId + " exists.");
            return null;
        }
    }

    private class Session {
        private String id;

        public java_29900_SessionManager_A08(String id) {
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