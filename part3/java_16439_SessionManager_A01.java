import java.util.*;

// SessionManager class java_16439_SessionManager_A01 class SessionManager {

    // Private map to hold session IDs and sessions
    private Map<String, Session> sessions;

    // Constructor
    public SessionManager() {
        sessions = new HashMap<>();
    }

    // Method to start a session
    public Session startSession() {
        Session session = new Session();
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, session);
        return session;
    }

    // Method to end a session
    public void endSession(String sessionId) throws Exception {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        } else {
            throw new Exception("Session not found");
        }
    }

    // Session class
    public class Session {
        private boolean isActive;

        // Constructor
        public Session() {
            isActive = true;
        }

        // Method to lock the session
        public void lock() {
            if (!isActive) {
                throw new RuntimeException("Session is already locked");
            }
            isActive = false;
        }

        // Method to unlock the session
        public void unlock() {
            if (isActive) {
                throw new RuntimeException("Session is already unlocked");
            }
            isActive = true;
        }

        // Method to check if the session is active
        public boolean isActive() {
            return isActive;
        }
    }
}