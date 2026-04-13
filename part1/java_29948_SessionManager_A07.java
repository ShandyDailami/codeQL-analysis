import java.util.HashMap;
import java.util.Map;

public class java_29948_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_29948_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName, String password) {
        // This is a security-sensitive operation related to authentication failure
        if (isAuthenticated(userName, password)) {
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(sessionId, userName);
            System.out.println("Session started for user: " + userName + ", sessionId: " + sessionId);
        } else {
            System.out.println("Authentication failed. Cannot start session.");
        }
    }

    private boolean isAuthenticated(String userName, String password) {
        // This is a placeholder for a real-world authentication mechanism
        // The actual implementation depends on the specific requirements of your application
        // This method is intentionally kept simple for demonstration purposes
        // For real-world scenarios, it's recommended to use a secure and robust authentication mechanism
        return userName.equals("admin") && password.equals("password");
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("No active session found for sessionId: " + sessionId);
        }
    }
}