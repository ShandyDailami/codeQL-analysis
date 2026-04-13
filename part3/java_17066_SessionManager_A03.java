import java.util.HashMap;
import java.util.Map;

public class java_17066_SessionManager_A03 {
    public static void main(String[] args) {
        // Create a session manager
        SessionManager sessionManager = new SessionManager();

        // Start a session
        Session session = sessionManager.startSession();

        // Set a value
        Map<String, String> value = new HashMap<>();
        value.put("key", "value");
        session.setAttribute("sessionValue", value);

        // Retrieve the value
        Map<String, String> retrievedValue = session.getAttribute("sessionValue");
        System.out.println("Retrieved value: " + retrievedValue);

        // Close the session
        sessionManager.closeSession(session);
    }
}

class SessionManager {
    // A simple in-memory session manager
    private Map<String, Session> sessions = new HashMap<>();

    public Session startSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session.getId());
    }
}

class Session {
    private String id;
    private Map<String, String> attributes = new HashMap<>();

    public java_17066_SessionManager_A03(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAttribute(String name, String value) {
        attributes.put(name, value);
    }

    public Map<String, String> getAttribute(String name) {
        Map<String, String> attribute = new HashMap<>();
        attribute.put(name, attributes.get(name));
        return attribute;
    }
}