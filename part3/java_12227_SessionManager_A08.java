import java.util.HashMap;

public class java_12227_SessionManager_A08 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Default constructor
    public java_12227_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Create a new session
        String sessionId = sm.createSession("session1");
        System.out.println("Created session with ID: " + sessionId);

        // Get a session
        String session = sm.getSession("session1");
        System.out.println("Got session: " + session);

        // Destroy a session
        sm.destroySession("session1");
        System.out.println("Destroyed session with ID: " + session);
    }
}