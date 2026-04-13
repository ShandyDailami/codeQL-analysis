import java.util.HashMap;
import java.util.Map;

public class java_22696_SessionManager_A01 {

    private Map<String, UserSession> sessionMap;

    public java_22696_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, UserSession userSession) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("User already has an active session. Logging out first.");
            logout(userId);
        }
        sessionMap.put(userId, userSession);
        System.out.println("New session started for user: " + userId);
    }

    public void logout(String userId) {
        if (sessionMap.containsKey(userId)) {
            UserSession userSession = sessionMap.get(userId);
            userSession.closeSession();
            sessionMap.remove(userId);
            System.out.println("User: " + userId + " has been logged out.");
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }

    public static class UserSession {

        private boolean isActive;

        public java_22696_SessionManager_A01() {
            this.isActive = true;
        }

        public void closeSession() {
            isActive = false;
            System.out.println("Session closed.");
        }
    }
}