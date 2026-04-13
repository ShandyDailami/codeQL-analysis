import java.util.HashMap;

public class java_05702_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_05702_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // Create a session with a user id
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // Retrieve the user id from the session id
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Delete a session
        sessionMap.remove(sessionId);
    }
}