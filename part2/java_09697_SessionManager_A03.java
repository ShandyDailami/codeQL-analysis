import java.util.HashSet;
import java.util.Set;

public class java_09697_SessionManager_A03 {

    // Set to hold all active sessions
    private Set<SecuritySession> activeSessions;

    public java_09697_SessionManager_A03() {
        activeSessions = new HashSet<>();
    }

    // Method to start a new session
    public SecuritySession startSession(String userId) {
        SecuritySession session = new SecuritySession(userId);
        activeSessions.add(session);
        return session;
    }

    // Method to end a session
    public void endSession(SecuritySession session) {
        activeSessions.remove(session);
    }

    // Method to get the active sessions
    public Set<SecuritySession> getActiveSessions() {
        return activeSessions;
    }

    // SecuritySession is a simple data class that contains the user's ID and a flag to indicate whether it's active
    public static class SecuritySession {
        private String userId;
        private boolean isActive;

        public java_09697_SessionManager_A03(String userId) {
            this.userId = userId;
            this.isActive = true;
        }

        public String getUserId() {
            return userId;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setInactive() {
            this.isActive = false;
        }
    }
}