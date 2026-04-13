import java.util.HashMap;
import java.util.Map;

public class java_01889_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_01889_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (validateUser(username, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Authentication failed.");
        }
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("No active session found with the given sessionId.");
        }
    }

    private boolean validateUser(String username, String password) {
        // This is a dummy authentication mechanism. In a real-world scenario, you'd use actual authentication mechanism.
        return username.equals("admin") && password.equals("password");
    }

    private String generateSessionId() {
        // This is a dummy session generation mechanism. In a real-world scenario, you'd use actual session generation mechanism.
        return "sessionId";
    }
}