import java.util.HashMap;

public class java_18792_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_18792_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // Here, you can generate a unique id for session using standard libraries
        // For example, you can use UUID, System.currentTimeMillis() or any other method
        return String.valueOf(System.currentTimeMillis());
    }
}