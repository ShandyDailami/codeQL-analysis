import java.util.HashMap;
import java.util.Map;

public class java_31458_SessionManager_A08 {
    private static Map<String, Object> sessions = new HashMap<>();

    public static void startSession(String sessionId, Object sessionObject) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists!");
        }
        sessions.put(sessionId, sessionObject);
    }

    public static void updateSession(String sessionId, Object sessionObject) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist!");
        }
        sessions.put(sessionId, sessionObject);
    }

    public static void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist!");
        }
        sessions.remove(sessionId);
    }

    public static Object getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist!");
        }
        return sessions.get(sessionId);
    }

    public static void endSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist!");
        }
        sessions.remove(sessionId);
    }
}