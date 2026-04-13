import java.util.HashMap;
import java.util.Map;

public class java_24933_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_24933_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user: " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + userName);
    }

    public void authenticate(String sessionId, String password) {
        String userName = sessionMap.get(sessionId);
        if (userName == null || !userName.equals(password)) { // Assuming password is hashed, no need for actual authentication
            System.out.println("Authentication failed for session: " + sessionId);
            endSession(sessionId);
        } else {
            System.out.println("Authentication succeeded for session: " + sessionId);
        }
    }

    public void authorize(String sessionId, String role) {
        String userName = sessionMap.get(sessionId);
        if (!userName.equals(role)) { // Assuming roles are hardcoded in a real application
            System.out.println("Authorization failed for session: " + sessionId);
            endSession(sessionId);
        } else {
            System.out.println("Authorization succeeded for session: " + sessionId);
        }
    }

    private String generateSessionId() {
        // This is a simple example, but in a real application, you would need to generate a secure session ID
        return "sessionId";
    }
}