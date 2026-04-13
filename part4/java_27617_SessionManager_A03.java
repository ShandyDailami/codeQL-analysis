import java.util.*;

public class java_27617_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_27617_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // method to start a session
    public String startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new RuntimeException("Session already exists for user: " + userId);
        }
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    // method to end a session
    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }
        sessionMap.remove(userId);
    }

    // method to get the session id for a user
    public String getSessionId(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }
        return sessionMap.get(userId);
    }
}