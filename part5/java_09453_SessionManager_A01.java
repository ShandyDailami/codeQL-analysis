import java.util.HashMap;

public class java_09453_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_09453_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        return null;
    }

    public void createSession(String sessionId, String sessionData) {
        sessions.put(sessionId, sessionData);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "data1");

        // Get session
        String sessionData = sessionManager.getSession("session1");
        System.out.println("Session data: " + sessionData);

        // Destroy session
        sessionManager.destroySession("session1");

        // Attempt to get destroyed session
        sessionData = sessionManager.getSession("session1");
        System.out.println("Attempt to get destroyed session data: " + sessionData);
    }
}