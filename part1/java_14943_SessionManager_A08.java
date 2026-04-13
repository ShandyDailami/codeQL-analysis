import java.util.HashMap;

public class java_14943_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_14943_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Start a session for a user
        // The session id is the username
        sessionMap.put(username, "session-" + username);
    }

    public String getSession(String username) {
        // Get the session id for a user
        // The session id is the username
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        // End a session for a user
        // The session id is the username
        sessionMap.remove(username);
    }

    public boolean isSessionActive(String username) {
        // Check if a session is active for a user
        // The session id is the username
        return sessionMap.containsKey(username);
    }

    public void clearSessions() {
        // Clear all sessions
        sessionMap.clear();
    }
}