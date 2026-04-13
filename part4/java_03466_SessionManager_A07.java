import java.util.HashMap;

public class java_03466_SessionManager_A07 {

    // Create a HashMap to store Session objects
    private HashMap<String, Session> sessionMap;

    public java_03466_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new Session
    public Session createSession(String sessionId) {
        Session session = new Session();
        session.setId(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a Session
    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
            return null;
        }
    }

    // Session class for demonstration
    public class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}