import java.util.HashMap;

public class java_32893_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_32893_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new RuntimeException("Session already exists for user: " + userId);
        }
        sessionMap.put(userId, createSession(userId));
    }

    public String getSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session to end for user: " + userId);
        }
        sessionMap.remove(userId);
    }

    private String createSession(String userId) {
        // Add session creation logic here, such as UUID or other session-specific details
        return "Session_" + userId;
    }
}