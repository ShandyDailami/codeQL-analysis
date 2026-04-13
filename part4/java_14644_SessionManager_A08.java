import java.util.HashMap;
import java.util.Map;

public class java_14644_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_14644_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        // For simplicity, we'll just check if the password is the same as the username
        // This would be a more complex check for security sensitive operations
        if (password.equals(username)) {
            sessionMap.put("sessionId", username);
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Invalid username or password. Session not started.");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get("sessionId");
            sessionMap.remove("sessionId");
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("No active session found for the provided sessionId.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("testUser", "testPassword");
        sessionManager.endSession("testUser");
    }
}