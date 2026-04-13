import java.util.HashMap;
import java.util.Map;

public class java_33179_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_33179_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = Integer.toString(sessions.size() + 1);
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " exists for user " + sessions.get(sessionId));
        } else {
            System.out.println("Session " + sessionId + " does not exist");
            // handle session expiration or invalidation
        }
    }

    public void checkAuthentication(String sessionId, String username) {
        if (sessions.containsKey(sessionId) && sessions.get(sessionId).equals(username)) {
            System.out.println("Authentication successful for session " + sessionId);
        } else {
            System.out.println("Authentication failed for session " + sessionId);
            // handle authentication failure
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("Alice");
        System.out.println("Created session " + sessionId + " for user Alice");

        sessionManager.checkSession(sessionId);
        sessionManager.checkAuthentication(sessionId, "Alice");

        String sessionId2 = sessionManager.createSession("Bob");
        System.out.println("Created session " + sessionId2 + " for user Bob");

        sessionManager.checkSession(sessionId2);
        sessionManager.checkAuthentication(sessionId2, "Bob");

        sessionManager.removeSession(sessionId2);
        System.out.println("Removed session " + sessionId2);
    }
}