import java.util.HashMap;
import java.util.Map;

public class java_39251_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_39251_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean checkIntegrity(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        // Starting a session
        securityManager.startSession("Alice");

        // Checking the integrity of the session
        String sessionId = securityManager.getSessionId();
        if (securityManager.checkIntegrity(sessionId)) {
            System.out.println("Session is valid.");
        } else {
            System.out.println("Session is invalid.");
        }

        // Ending the session
        securityManager.endSession(sessionId);
    }
}