import java.util.HashMap;
import java.util.Map;

public class java_14893_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_14893_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void authenticateSession(String sessionId, String password) {
        String userId = sessionMap.get(sessionId);
        // Here you can implement actual authentication logic using a secure HashMap or a real authentication service
        // For this example, let's assume a simple hashmap for simplicity
        Map<String, String> authMap = new HashMap<>();
        authMap.put("userId", "password");

        if (authMap.get(userId).equals(password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
            // If authentication fails, end the session
            endSession(sessionId);
        }
    }
}