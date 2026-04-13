import java.util.ArrayList;
import java.util.List;

public class java_02638_SessionManager_A08 {
    private static final List<String> activeSessions = new ArrayList<>();

    public static void startSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
        }
    }

    public static void endSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public static boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static boolean hasActiveSessions() {
        return !activeSessions.isEmpty();
    }
}