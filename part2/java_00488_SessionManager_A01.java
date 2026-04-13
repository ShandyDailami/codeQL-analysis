import java.util.HashMap;
import java.util.Map;

public class java_00488_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_00488_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (isValidCredentials(username, password)) {
            String sessionId = UUID.randomUUID().toString();
            sessions.put(sessionId, username);
            System.out.println("Session created with ID: " + sessionId);
        } else {
            System.out.println("Invalid credentials. Cannot create session.");
        }
    }

    public String getUsername(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            System.out.println("Invalid session ID. Cannot retrieve username.");
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String username = sessions.get(sessionId);
            sessions.remove(sessionId);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("Invalid session ID. Cannot end session.");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Simulate a database lookup to check if username and password match a valid user in the system.
        // This is a very basic example and doesn't involve real security measures.
        return username.equals("admin") && password.equals("password");
    }
}