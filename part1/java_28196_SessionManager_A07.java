import java.util.HashMap;

public class java_28196_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_28196_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // You could generate a session ID here using some cryptographic or UUID functions
        // This is just a simple example and not recommended for real-world applications
        return "sessionId";
    }
}