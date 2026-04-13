import java.util.HashMap;

public class java_27140_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_27140_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = "session" + System.currentTimeMillis();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("user1");

        // Get the username from the session
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        // Destroy the session
        sessionManager.destroySession(sessionId);
    }
}