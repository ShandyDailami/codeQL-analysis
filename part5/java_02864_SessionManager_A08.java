import java.util.HashSet;
import java.util.Set;

public class java_02864_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_02864_SessionManager_A08() {
        this.activeSessions = new HashSet<>();
    }

    public void startSession(String sessionId) throws SessionAlreadyExistsException {
        if (activeSessions.contains(sessionId)) {
            throw new SessionAlreadyExistsException("Session with ID: " + sessionId + " already exists.");
        }
        activeSessions.add(sessionId);
    }

    public void endSession(String sessionId) throws SessionDoesNotExistException {
        if (!activeSessions.contains(sessionId)) {
            throw new SessionDoesNotExistException("Session with ID: " + sessionId + " does not exist.");
       
        }
        activeSessions.remove(sessionId);
    }

    public void validateSession(String sessionId) throws SessionDoesNotExistException {
        if (!activeSessions.contains(sessionId)) {
            throw new SessionDoesNotExistException("Session with ID: " + sessionId + " does not exist.");
        }
    }

    public static class SessionAlreadyExistsException extends Exception {
        public java_02864_SessionManager_A08(String message) {
            super(message);
        }
    }

    public static class SessionDoesNotExistException extends Exception {
        public java_02864_SessionManager_A08(String message) {
            super(message);
        }
    }
}