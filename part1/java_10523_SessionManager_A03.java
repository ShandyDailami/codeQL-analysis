import java.util.HashMap;
import java.util.Map;

public class java_10523_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_10523_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // The session starts with the user providing a session id and user id
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        // The session retrieves the user id from the session id
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // The session ends by removing the user id associated with the session id
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        // The session checks if the session id is valid
        return sessionMap.containsKey(sessionId);
    }
}