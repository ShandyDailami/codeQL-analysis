import java.util.Optional;

public class java_12208_SessionManager_A07 {
    private static Optional<Session> currentSession;

    // A static method to create a session
    public static void createSession(String sessionId) {
        if (currentSession.isPresent()) {
            throw new IllegalStateException("Attempted to create a new session when there was already a session.");
        } else {
            currentSession = Optional.of(new Session(sessionId));
        }
    }

    // A static method to end a session
    public static void endSession(String sessionId) {
        if (currentSession.isEmpty()) {
            throw new IllegalStateException("Attempted to end non-existing session.");
        } else if (!currentSession.get().getId().equals(sessionId)) {
            throw new IllegalStateException("Attempted to end session with id " + sessionId + " when there was no session with id " + sessionId);
        } else {
            currentSession = Optional.empty();
        }
    }

    public static class Session {
        private String id;

        public java_12208_SessionManager_A07(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}