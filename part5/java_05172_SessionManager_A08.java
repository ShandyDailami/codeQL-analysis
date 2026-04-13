import java.util.HashMap;
import java.util.Map;

public class java_05172_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_05172_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValidCredentials(username, password)) {
            String sessionId = generateSessionId();
            sessions.put(sessionId, username);
            System.out.println("Session started for user: " + username + " with session id: " + sessionId);
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String username = sessions.get(sessionId);
            sessions.remove(sessionId);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("No active session found for session id: " + sessionId);
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // This is a simple check for now. In a real application, you would have a real authentication system.
        return username.equals("admin") && password.equals("password");
    }

    private String generateSessionId() {
        // This is a simple random session id generation. In a real application, you would have a real session management system.
        return String.valueOf(System.currentTimeMillis());
    }
}