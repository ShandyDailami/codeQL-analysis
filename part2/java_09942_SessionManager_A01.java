import java.util.HashMap;
import java.util.Map;

public class java_09942_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_09942_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("alice");
        System.out.println("Session ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        sessionManager.deleteSession(sessionId);
    }
}