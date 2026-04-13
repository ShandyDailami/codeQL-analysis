import java.util.HashSet;
import java.util.Set;

public class java_19414_SessionManager_A07 {
    private static final Set<String> activeSessions = new HashSet<>();

    public static void startSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }
        activeSessions.add(sessionId);
    }

    public static void endSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            throw new RuntimeException("No active session with id: " + sessionId);
        }
        activeSessions.remove(sessionId);
    }

    public static boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void invalidateAllSessions() {
        activeSessions.clear();
    }
}