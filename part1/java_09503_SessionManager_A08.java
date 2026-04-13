import java.util.*;

public class java_09503_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_09503_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        sessions.put(userId, UUID.randomUUID().toString());
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public void setSecurityManager(SecurityManager securityManager) {
        securityManager.setSessionManager(this);
    }

    public String getSessionKey(String userId) {
        return sessions.get(userId);
    }

    public static class SecurityManager {
        private SessionManager sessionManager;

        public void setSessionManager(SessionManager sessionManager) {
            this.sessionManager = sessionManager;
        }

        public void checkSessionValidity(String userId, String sessionKey) {
            String sessionId = sessionManager.getSessionKey(userId);
            if (sessionId == null || !sessionId.equals(sessionKey)) {
                throw new SecurityFailureException("Invalid session key");
            }
        }
    }
}