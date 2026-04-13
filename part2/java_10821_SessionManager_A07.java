import java.util.HashMap;
import java.util.Map;

public class java_10821_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_10821_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class SecurityManager {
    public boolean authenticate(String userId, String sessionId) {
        SessionManager sessionManager = new SessionManager();
        String user = sessionManager.getUserId(sessionId);
        if (user != null && user.equals(userId)) {
            sessionManager.endSession(sessionId);
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        if (securityManager.authenticate("user1", "session1")) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}