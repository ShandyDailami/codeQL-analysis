import java.util.*;

public class java_26562_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_26562_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        // The user starts a session by providing a user ID and a session ID.
        // The session ID is used to identify the user.
        // The user ID is used to track the user.
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // The user retrieves the user ID associated with a session ID.
        // The session ID is used to identify the user.
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // The user ends the session by providing a session ID.
        // The session ID is used to identify the user.
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        // The user checks if a session is active by providing a session ID.
        // The session ID is used to identify the user.
        // If the session is active, it returns true, otherwise it returns false.
        return sessionMap.containsKey(sessionId);
    }
}