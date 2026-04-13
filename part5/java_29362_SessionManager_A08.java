import java.util.HashMap;
import java.util.Map;

public class java_29362_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_29362_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        if (sessionMap.containsKey(username)) {
            System.out.println("Error: User already has an existing session. " +
                    "Cannot create a new session for user: " + username);
        } else {
            sessionMap.put(username, sessionId);
            System.out.println("Successfully created a new session for user: " + username);
        }
    }

    public void validateSession(String username, String sessionId) {
        if (!sessionMap.containsKey(username) || !sessionMap.get(username).equals(sessionId)) {
            System.out.println("Error: Invalid session. User: " + username + " tried to access the session: " + sessionId);
        } else {
            System.out.println("Successfully validated session for user: " + username);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("alice", "session1");
        sessionManager.createSession("bob", "session2");
        sessionManager.validateSession("alice", "session1");
        sessionManager.validateSession("bob", "session2");
        sessionManager.validateSession("alice", "session3");
    }
}