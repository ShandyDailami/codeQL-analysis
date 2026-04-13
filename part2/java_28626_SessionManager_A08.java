import java.util.HashSet;
import java.util.Set;

public class java_28626_SessionManager_A08 {
    private Set<Session> activeSessions;

    public java_28626_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public Session createSession() {
        Session session = new Session();
        activeSessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        activeSessions.remove(session);
    }

    public static class Session {
        private boolean isActive;

        public java_28626_SessionManager_A08() {
            isActive = true;
        }

        public void checkIntegrity() {
            if (!isActive) {
                throw new SecurityFailureException("Session is not active");
            }
        }
    }
}

class SecurityFailureException extends RuntimeException {
    public java_28626_SessionManager_A08(String message) {
        super(message);
    }
}