import java.util.HashMap;

public class java_16571_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_16571_SessionManager_A08() {
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

    public boolean checkSessionId(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example, real implementation may involve generating a UUID
        return String.valueOf(System.nanoTime());
    }
}