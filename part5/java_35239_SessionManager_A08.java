import java.util.HashMap;

public class java_35239_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_35239_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, userId);
        System.out.println("Session Started: " + sessionId);
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String userId = sessions.get(sessionId);
            sessions.remove(sessionId);
            System.out.println("Session Ended: " + sessionId + ", User: " + userId);
        } else {
            System.out.println("Session Not Found: " + sessionId);
        }
    }

    private String generateSessionId() {
        // This is a simple and not secure way to generate session ID. 
        // In a real-world scenario, you should use UUID or similar to generate a unique id.
        return String.valueOf(System.currentTimeMillis());
    }
}