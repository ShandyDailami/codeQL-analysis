import java.util.HashMap;
import java.util.Map;

public class java_26348_SessionManager_A03 {
    // A map to hold session objects
    private Map<String, Session> sessionMap;

    // A counter to generate session IDs
    private int sessionCount;

    // A constructor to create a new session manager
    public java_26348_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
        this.sessionCount = 0;
    }

    // A method to start a new session
    public Session startSession() {
        String sessionId = "S" + (sessionCount++);
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // A method to get a session
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID: " + sessionId);
        }
        return session;
    }

    // A class to represent a session
    public class Session {
        private String id;

        public java_26348_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        // Simulate a method to add a property to the session
        public void setProperty(String name, String value) {
            // Here we are simulating an injection attack by setting a property
            // to a value that we don't have permission to access
            System.out.println("Setting property " + name + " = " + value + " for session " + id);
        }
    }
}