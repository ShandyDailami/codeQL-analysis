import java.util.*;

public class java_36955_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_36955_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // If session already exists, throw an exception
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists");
        }

        // Otherwise, start the session
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // If session does not exist, return null
        if (!sessions.containsKey(sessionId)) {
            return null;
        }

        // Otherwise, return the user id
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        // If session does not exist, return null
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist");
        }

        // Otherwise, end the session
        sessions.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        // If session does not exist, return null
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist");
        }

        // Otherwise, session is valid
    }
}