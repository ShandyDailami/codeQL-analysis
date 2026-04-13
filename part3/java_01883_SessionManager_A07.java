import java.util.HashMap;
import java.util.Map;

public class java_01883_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_01883_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
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
        System.out.println("Created session: " + sessionId);

        // Get the user from the session
        String user = sessionManager.getUser(sessionId);
        System.out.println("User: " + user);

        // Destroy the session
        sessionManager.destroySession(sessionId);
    }
}