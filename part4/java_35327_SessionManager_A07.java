import java.util.HashMap;
import java.util.Map;

public class java_35327_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_35327_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = "A07_" + System.currentTimeMillis();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Session ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        sessionManager.deleteSession(sessionId);

        boolean isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is valid session: " + isValid);
    }
}